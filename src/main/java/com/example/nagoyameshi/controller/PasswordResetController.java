package com.example.nagoyameshi.controller;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.PasswordResetToken;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.PasswordEditForm;
import com.example.nagoyameshi.form.PasswordresetForm;
import com.example.nagoyameshi.repository.PasswordResetTokenRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.service.UserService;

import jakarta.validation.Valid;

@Controller
public class PasswordResetController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private PasswordResetTokenRepository tokenRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/passwordreset")
    public String showPasswordResetForm(Model model) {
        model.addAttribute("passwordresetForm", new PasswordresetForm());
        return "auth/passwordreset";
    }

    @PostMapping("/passwordreset")
    public String handlePasswordReset(@Valid PasswordresetForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/passwordreset";
        }

        String email = form.getEmail();
        User user = userService.findUserByEmail(email);
        if (user == null) {
            model.addAttribute("errorMessage", "メールアドレスが登録されていません。");
            return "auth/passwordreset";
        }

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);

        String resetUrl = "http://localhost:8080/passwordedit?token=" + token;
        
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setTo(email);
        emailMessage.setSubject("パスワードリセットリクエスト");
        emailMessage.setText("以下のURLよりパスワードをリセットしてください。\n" + resetUrl);

        mailSender.send(emailMessage);

        model.addAttribute("successMessage", "ご入力いただいたメールアドレスに認証メールを送信しました。メールに記載されているリンクをクリックし、会員登録を完了してください。");
        return "auth/passwordreset";
    }
    
    @GetMapping("/passwordedit")
    public String showPasswordEditForm(@RequestParam("token") String token, Model model) {
        PasswordEditForm passwordEditForm = new PasswordEditForm();
        passwordEditForm.setToken(token);
        model.addAttribute("passwordEditForm", passwordEditForm);
        return "auth/passwordedit";
    }
    
    @PostMapping("/passwordedit")
    public String handlePasswordEdit(@Valid PasswordEditForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "auth/passwordedit";
        }

        // パスワードが一致しているか確認
        if (!form.getPassword().equals(form.getPasswordConfirmation())) {
            bindingResult.rejectValue("passwordConfirmation", "error.passwordEditForm", "パスワードが一致しません。");
            return "auth/passwordedit";
        }
        
        String result = userService.validatePasswordResetToken(form.getToken());
        if (result != null) {
            redirectAttributes.addAttribute("errorMessage", "トークンが無効です。再度リセットを試みてください。");
            return "redirect:/passwordreset";
        }

        // 新しいパスワードの設定
        User user = userService.getUserByPasswordResetToken(form.getToken());
        userService.updatePassword(user, form.getPassword());

        redirectAttributes.addFlashAttribute("successMessage", "パスワード再設定が完了しました");
        return "redirect:/login";
        
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(
            @RequestParam("token") String token,
            @RequestParam("password") String newPassword,
            @RequestParam("passwordConfirmation") String passwordConfirmation) {

        if (!newPassword.equals(passwordConfirmation)) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }

        String tokenResult = validatePasswordResetToken(token);
        if (tokenResult != null) {
            return ResponseEntity.badRequest().body(tokenResult);
        }

        User user = getUserByPasswordResetToken(token);
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        updatePassword(user, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }

    public User getUserByPasswordResetToken(String token) {
        PasswordResetToken passToken = PasswordResetTokenRepository.findByToken(token);
        return passToken == null ? null : passToken.getUser();
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public String validatePasswordResetToken(String token) {
        PasswordResetToken passToken = PasswordResetTokenRepository.findByToken(token);
        if (passToken == null) {
            return "invalidToken";
        }

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "expired";
        }

        return null;
    }
}
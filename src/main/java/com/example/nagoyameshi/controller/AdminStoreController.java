package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.StoreEditForm;
import com.example.nagoyameshi.form.StoreRegisterForm;
import com.example.nagoyameshi.form.UserEditForm;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.StoreService;
import com.example.nagoyameshi.service.UserService;
 
 @Controller
 @RequestMapping("/admin")
public class AdminStoreController {
     private final StoreRepository storeRepository;
     private final StoreService storeService;
     private final UserRepository userRepository;
     private final UserService userService;
     
     public AdminStoreController(StoreRepository storeRepository, StoreService storeService, UserRepository userRepository, UserService userService) {
    	this.storeRepository = storeRepository;
        this.storeService = storeService;
        this.userRepository = userRepository;
        this.userService = userService;                 
     }	
     
     @GetMapping("/stores")
     public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword)  {
    	 Page<Store> storePage ;
    	 
    	 if (keyword != null && !keyword.isEmpty()) {
             storePage = storeRepository.findByCategoryLike("%" + keyword + "%", pageable);                
         } else {
             storePage = storeRepository.findAll(pageable);
         } 
         
    	 model.addAttribute("storePage", storePage);
    	 model.addAttribute("keyword", keyword);             
         
         return "admin/stores/index";
     }
     
     @GetMapping("/stores/{id}")
     public String show(@PathVariable(name = "id") Integer id, Model model) {
         Store store = storeRepository.getReferenceById(id);
         
         model.addAttribute("store", store);
         
         return "admin/stores/show";
     }
     
     @GetMapping("/stores/register")
     public String register(Model model) {
         model.addAttribute("storeRegisterForm", new StoreRegisterForm());
         return "admin/stores/register";
     }
     
     @PostMapping("/stores/create")
     public String create(@ModelAttribute @Validated StoreRegisterForm storeRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
         if (bindingResult.hasErrors()) {
             return "admin/stores/register";
         }
         
         storeService.create(storeRegisterForm);
         redirectAttributes.addFlashAttribute("successMessage", "店舗を登録しました。");    
         
         return "redirect:/admin/stores";
     }
     
     @GetMapping("/stores/{id}/edit")
     public String editStore(@PathVariable(name = "id") Integer id, Model model) {
         Store store = storeRepository.getReferenceById(id);
         String imageName = store.getImageName();
         StoreEditForm storeEditForm = new StoreEditForm(store.getId(), store.getName(), null, store.getPrice(), store.getDescription(), store.getPostalCode(), store.getAddress(), store.getBusinessHours(), store.getPhoneNumber());
         
         model.addAttribute("imageName", imageName);
         model.addAttribute("storeEditForm", storeEditForm);
         
         return "admin/stores/edit";
     }
     
     @PostMapping("/stores/{id}/update")
     public String updateStore(@ModelAttribute @Validated StoreEditForm storeEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
         if (bindingResult.hasErrors()) {
             return "admin/stores/edit";
         }
         
         storeService.update(storeEditForm);
         redirectAttributes.addFlashAttribute("successMessage", "店舗情報を編集しました。");
         
         return "redirect:/admin/stores";
     }
     
     @PostMapping("/stores/{id}/delete")
     public String deleteStore(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {        
         storeRepository.deleteById(id);
                 
         redirectAttributes.addFlashAttribute("successMessage", "店舗を削除しました。");
         
         return "redirect:/admin/stores";
     } 
     
     @GetMapping("/users/{id}/edit")
     
     public String editUser(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
         User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
         UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getFurigana(), user.getPostalCode(), user.getAddress(), user.getPhoneNumber(), user.getEmail());
         
         model.addAttribute("userEditForm", userEditForm);
         
         return "admin/users/edit";
     } 
     
     @PostMapping("/users/{id}/update")
     public String updateUser(@ModelAttribute @Validated UserEditForm userEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
         if (bindingResult.hasErrors()) {
             return "admin/users/edit";
         }
         
         userService.update(userEditForm);
         redirectAttributes.addFlashAttribute("successMessage", "会員情報を編集しました。");
         
         return "redirect:/admin/users";
     } 
     
     @PostMapping("users/{id}/delete")
     public String deleteUser(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {        
         userRepository.deleteById(id);
                 
         redirectAttributes.addFlashAttribute("successMessage", "会員登録を削除しました。");
         
         return "redirect:/admin/users";
     } 
}

 
 
 
 
 
 
 
 
 
 
 
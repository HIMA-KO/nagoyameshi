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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReviewRegisterForm;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.ReviewService;


@Controller
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final StoreRepository storeRepository;
	private final ReviewService reviewService;

    
    public ReviewController(ReviewRepository reviewRepository, StoreRepository storeRepository,ReviewService reviewService) {
        this.reviewRepository = reviewRepository;
        this.storeRepository = storeRepository;
        this.reviewService = reviewService;  
    } 
   
    
    @GetMapping("/review")
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
        User user = userDetailsImpl.getUser();
        Page<Review> reviewPage = reviewRepository.findByUserOrderByCreatedAtDesc(user, pageable);
        
        model.addAttribute("reviewPage", reviewPage);         
        
        return "review/index";
    }
    
    @PostMapping("/review/{id}/delete")
    public String deleteReview(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {        
        reviewRepository.deleteById(id);
                
        redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました。");
        
        return "redirect:/review";
    }
    
   @GetMapping("/review/register")
   public String register(Model model) {
	   
       model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
        return "review/register";
    } 
    
    @PostMapping("/review/create")
    public String create(@ModelAttribute @Validated ReviewRegisterForm reviewRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
        if (bindingResult.hasErrors()) {
            return "review/register";
        }
        
        reviewService.create(reviewRegisterForm);
        redirectAttributes.addFlashAttribute("successMessage", "レビューを登録しました。");    
        
        return "redirect:/review";
    }   
}

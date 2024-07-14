package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
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
    
    @GetMapping("/store/{storeId}")
    public String showStoreDetails(@PathVariable Long storeId, Model model) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));
        List<Review> review = reviewRepository.findByStoreId(storeId);
        
        model.addAttribute("store", store);
        model.addAttribute("reviews", review);
        return "stores/show";
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
    

//   @GetMapping("/review/register")
//   public String register(Model model) {
//	   List<Store> stores = storeRepository.findAll();
//       model.addAttribute("stores", stores);	   
//       model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
//        return "review/register";
//    } 
//    
//   @PostMapping("/review/create")
//   public String create(@ModelAttribute @Validated ReviewRegisterForm reviewRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {        
//       if (bindingResult.hasErrors()) {
//           return "review/register";
//       }
//       
//       reviewService.create(reviewRegisterForm);
//       redirectAttributes.addFlashAttribute("successMessage", "レビューを登録しました。");    
//       
//       return "redirect:/review";
//   }
   
    @GetMapping("/review/register")
    public String register(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
        return "review/register";
    }

    @PostMapping("/review/create")
    public String create(@ModelAttribute @Validated ReviewRegisterForm reviewRegisterForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (bindingResult.hasErrors()) {
            return "review/register";
        }

        User user = userDetails.getUser();
        reviewService.create(reviewRegisterForm, user);

        redirectAttributes.addFlashAttribute("successMessage", "レビューを登録しました。");
        return "redirect:/review";
    }
 
   @PostMapping("/reviews")
   public ResponseEntity<Void> createReview(@RequestBody ReviewRegisterForm reviewRegisterForm, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
       User user = userDetailsImpl.getUser();
       reviewRegisterForm.setUserId(user.getId());
       reviewService.create(reviewRegisterForm, user);
       return ResponseEntity.status(HttpStatus.CREATED).build();
   }
   

   

}

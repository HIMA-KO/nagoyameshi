package com.example.nagoyameshi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReviewRegisterForm;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;

 @Service
 public class ReviewService {
     private final ReviewRepository reviewRepository; 
     private final StoreRepository storeRepository;
     private final UserRepository userRepository;
     
     @Autowired
     public ReviewService(ReviewRepository reviewRepository, StoreRepository storeRepository,UserRepository userRepository) {
         this.reviewRepository = reviewRepository;
         this.storeRepository = storeRepository; 
         this.userRepository = userRepository; 
     }    
     
     @Transactional
     public void create(ReviewRegisterForm reviewRegisterForm,User user) {
         Review review = new Review();        
                      
         review.setReviewComment(reviewRegisterForm.getReviewComment());
         
         Store store = storeRepository.findById(reviewRegisterForm.getStoreId())
                 .orElseThrow(() -> new IllegalArgumentException("Invalid store Id:" + reviewRegisterForm.getStoreId()));
         review.setStore(store);
         
         review.setUser(user);
                     
         reviewRepository.save(review);
     }
     
     public List<Review> getReviewsByStoreId(Long storeId) {
         return reviewRepository.findByStoreId(storeId);
     }
     
}

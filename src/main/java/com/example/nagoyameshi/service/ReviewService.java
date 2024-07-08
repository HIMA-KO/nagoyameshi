package com.example.nagoyameshi.service;

 
 import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.form.ReviewRegisterForm;
import com.example.nagoyameshi.repository.ReviewRepository;
 
 @Service
 public class ReviewService {
     private final ReviewRepository reviewRepository;    
     
     public ReviewService(ReviewRepository reviewRepository) {
         this.reviewRepository = reviewRepository;        
     }    
     
     @Transactional
     public void create(ReviewRegisterForm reviewRegisterForm) {
         Review review = new Review();        
                      
         review.setReviewComment(reviewRegisterForm.getReviewComment());

                     
         reviewRepository.save(review);
     }  
     
}

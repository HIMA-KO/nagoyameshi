package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRegisterForm {    
     @NotBlank(message = "コメントを入力してください。")
     private String reviewComment;
     
     private Integer storeId;
     
     private Integer userId;  
     
     public Integer getStoreId() {
         return storeId;
     }

     public void setStoreId(Integer storeId) {
         this.storeId = storeId;
     }

}

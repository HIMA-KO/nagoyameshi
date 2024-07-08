package com.example.nagoyameshi.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreRegisterForm {
	@NotBlank(message = "店舗名を入力してください。")
    private String name;
        
    private MultipartFile imageFile;
    
    @NotBlank(message = "価格を入力してください。")
    private Integer price;
    
    @NotBlank(message = "説明を入力してください。")
    private String description;   
    
    @NotBlank(message = "郵便番号を入力してください。")
    private String postalCode;
    
    @NotBlank(message = "住所を入力してください。")
    private String address;
    
    @NotBlank(message = "営業時間を入力してください。")
    private String businessHours;
    
    @NotBlank(message = "電話番号を入力してください。")
    private String phoneNumber;

}

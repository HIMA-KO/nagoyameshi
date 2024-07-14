package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotBlank;

public class CategoryRegisterForm {
	 @NotBlank(message = "カテゴリー名を入力してください。")
     private String name;
	 
	 public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

}

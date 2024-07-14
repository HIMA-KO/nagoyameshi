package com.example.nagoyameshi.form;


import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordEditForm {

	    
	    @NotBlank(message = "パスワードを入力してください。")
	    @Length(min = 8, message = "パスワードは8文字以上で入力してください。")
	    private String password;    
	    
	    @NotBlank(message = "パスワード（確認用）を入力してください。")
	    private String passwordConfirmation;

		private String token;

		public Integer getId() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		public void setToken(String token) {
		        this.token = token;
		    }

		public String getToken() {
	        return token();
	    }
		
		 private String token() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		public String getPassword() {
		 return password;
		}

		 public void setPassword(String password) {
		 this.password = password;
		}
		 
		 public String getPasswordConfirmation() {
		    return passwordConfirmation;
		}
		
		public void setPasswordConfirmation(String passwordConfirmation) {
		    this.passwordConfirmation = passwordConfirmation;
		}

		public static Integer getEmail() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

	}




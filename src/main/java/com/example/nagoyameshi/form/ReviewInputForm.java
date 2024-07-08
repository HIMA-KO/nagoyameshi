package com.example.nagoyameshi.form;


	import jakarta.validation.constraints.NotBlank;
import lombok.Data;

	@Data
	public class ReviewInputForm {   
	     @NotBlank(message = "コメントを入力してください。")
	     private String reviewComment;

}

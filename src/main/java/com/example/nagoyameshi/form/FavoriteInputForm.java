package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class FavoriteInputForm {
    @NotBlank(message = "民宿名を入力してください。")
    private String name;
}
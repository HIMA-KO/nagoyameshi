//package com.example.nagoyameshi.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.nagoyameshi.repository.CategoryRepository;
//
//
//
//@Controller
//@RequestMapping("/admin/category")
//public class AdminCategoryController {
//	private final CategoryRepository categoryRepository;         
//    
//    public AdminCategoryController(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;                
//    }	
    
//    @GetMapping
//    public String index(Model model) {
//        List<Category> category = categoryRepository.findAll();       
//        
//        model.addAttribute("Category", category);             
//        
//        return "admin/category/index";
//    }

//}

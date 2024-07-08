package com.example.nagoyameshi.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.FavoriteInputForm;
import com.example.nagoyameshi.form.FavoriteRegisterForm;
import com.example.nagoyameshi.repository.FavoriteRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.FavoriteService;


@Controller
public class FavoriteController {
	private final FavoriteRepository favoriteRepository;      
	private final StoreRepository storeRepository;
    private final FavoriteService favoriteService; 
    
    public FavoriteController(FavoriteRepository favoriteRepository, StoreRepository storeRepository, FavoriteService favoriteService) { 
    	this.storeRepository = storeRepository;
    	this.favoriteRepository = favoriteRepository;  
    	this.favoriteService = favoriteService;
    }    


    
    @GetMapping("/favorite")
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
        User user = userDetailsImpl.getUser();
        Page<Favorite> favoritePage = favoriteRepository.findByUserOrderByCreatedAtDesc(user, pageable);
        
        model.addAttribute("favoritePage", favoritePage);         
        
        return "favorite/index";
    }
    
    @PostMapping("/favorite/{id}/delete")
    public String deleteFavorite(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {        
        favoriteRepository.deleteById(id);
                
        redirectAttributes.addFlashAttribute("successMessage", "お気に入り登録を削除しました。");
        
        return "redirect:/favorite";
    } 
    
    @GetMapping("/stores/{id}/favorite/input")
    public String input(@PathVariable(name = "id") Integer id,
        @ModelAttribute @Validated FavoriteInputForm favoriteInputForm,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes,
        Model model)
    {   
        Store store = storeRepository.getReferenceById(id);    
        redirectAttributes.addFlashAttribute("favoriteInputForm", favoriteInputForm);           
        
        return "redirect:/stores/"+ id + "/favorite/confirm";
    }    
    
    
    @GetMapping("/stores/{id}/favorite/confirm")
    public String confirm(@PathVariable(name = "id") Integer id,
                          @ModelAttribute FavoriteInputForm favoriteInputForm,
                          @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,                          
                          Model model) 
    {        
        Store store = storeRepository.getReferenceById(id);
        User user = userDetailsImpl.getUser(); 
                
        
        FavoriteRegisterForm favoriteRegisterForm = new FavoriteRegisterForm(store.getId(), user.getId(), store);
        
        model.addAttribute("store", store);  
        model.addAttribute("favoriteRegisterForm", favoriteRegisterForm);       
        
        return "favorite/confirm";
    } 
    
    @PostMapping("/stores/{id}/favorite/create")
    public String create(@ModelAttribute FavoriteRegisterForm favoriteRegisterForm) {                
        favoriteService.create(favoriteRegisterForm);        
        
        return "redirect:/favorite?reserved";
    }


}



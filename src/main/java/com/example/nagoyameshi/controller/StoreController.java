package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.ReservationInputForm;
import com.example.nagoyameshi.repository.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
	private final StoreRepository storeRepository;        
    
    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;            
    }     
  
    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "category", required = false) String category,
                        @RequestParam(name = "price", required = false) Integer price,
                        @RequestParam(name = "order", required = false) String order,
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model) 
    {
        Page<Store> storePage = null;
                
        if (keyword != null && !keyword.isEmpty()) {
        if (order != null && order.equals("priceAsc")) {
         storePage = storeRepository.findByNameLikeOrderByPriceAsc("%" + keyword + "%", pageable);
        } else if ("priceDesc".equals(order)) {
            storePage = storeRepository.findByNameLikeOrderByPriceDesc("%" + keyword + "%", pageable);
        } 
        else {
        	 storePage = storeRepository.findByNameLikeOrderByCreatedAtDesc("%" + keyword + "%", pageable);
        }
        }  else if (category != null && !category.isEmpty()) {
        if (order != null && order.equals("priceAsc")) {
        storePage = storeRepository.findByCategory_NameOrderByPriceAsc(category, pageable);
        } else if ("priceDesc".equals(order)) {
            storePage = storeRepository.findByCategory_NameOrderByPriceDesc(category, pageable);
        }else {
        	storePage = storeRepository.findByCategory_NameOrderByCreatedAtDesc(category, pageable);
        }
        }  else if (price != null) {
        	if (order != null && order.equals("priceAsc")) {
            storePage = storeRepository.findByPriceLessThanEqualOrderByPriceAsc(price, pageable);
        } else if ("priceDesc".equals(order)) {
            storePage = storeRepository.findByPriceLessThanEqualOrderByPriceDesc(price, pageable);
        } 
        else {
            storePage = storeRepository.findByPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);
        }
        }
        else {
            if ("priceAsc".equals(order)) {
                storePage = storeRepository.findAllByOrderByPriceAsc(pageable);
            } else if ("priceDesc".equals(order)) {
                storePage = storeRepository.findAllByOrderByPriceDesc(pageable);
            } else {
                storePage = storeRepository.findAllByOrderByCreatedAtDesc(pageable);
            }        
        }                
        
        model.addAttribute("storePage", storePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);
        model.addAttribute("price", price);
        model.addAttribute("order", order);
        
        return "stores/index";
    }
     
     @GetMapping("/{id}")
     public String show(@PathVariable(name = "id") Integer id, Model model) {
         Store store = storeRepository.getReferenceById(id);
         
         model.addAttribute("store", store);
         model.addAttribute("reservationInputForm", new ReservationInputForm());
         
         return "stores/show";
     }
     

    
     

 }

 
 
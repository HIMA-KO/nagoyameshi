package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.FavoriteRegisterForm;
import com.example.nagoyameshi.repository.FavoriteRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;

 
 
@Service
public class FavoriteService {
	private final FavoriteRepository favoriteRepository;  
    private final StoreRepository storeRepository;  
    private final UserRepository userRepository;  
    
    public FavoriteService(FavoriteRepository favoriteRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;  
        this.storeRepository = storeRepository;  
        this.userRepository = userRepository;  
    }    
    
    @Transactional
    public void create(FavoriteRegisterForm favoriteRegisterForm) { 
        Favorite favorite = new Favorite();
        Store store = storeRepository.getReferenceById(favoriteRegisterForm.getStoreId());
        User user = userRepository.getReferenceById(favoriteRegisterForm.getUserId());
//        LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
//        LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());         
                
        favorite.setStore(store);
        favorite.setUser(user);
//        reservation.setCheckinDate(checkinDate);
//        reservation.setCheckoutDate(checkoutDate);
//        reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
//        reservation.setAmount(reservationRegisterForm.getAmount());
        
        favoriteRepository.save(favorite);
    }
}

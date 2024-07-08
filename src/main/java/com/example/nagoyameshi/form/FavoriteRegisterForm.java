package com.example.nagoyameshi.form;


import com.example.nagoyameshi.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteRegisterForm {
	
	private Integer storeId;
    
    private Integer userId;    
    
    private Store store;
    
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
     public Page<Store> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);
     public Page<Store> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable); 
     public Page<Store> findAllByOrderByCreatedAtDesc(Pageable pageable);
     public Page<Store> findAllByOrderByPriceAsc(Pageable pageable);
     public Page<Store> findByCategoryLike(String category, Pageable pageable);
     public List<Store> findTop10ByOrderByCreatedAtDesc(); 
     public Page<Store> findByCategory_NameOrderByPriceAsc(String categoryName, Pageable pageable);
     public Page<Store> findByCategory_NameOrderByCreatedAtDesc(String categoryName, Pageable pageable);
     public Page<Store> findByNameLikeOrderByPriceAsc(String string, Pageable pageable);
     public Page<Store> findByNameLikeOrderByCreatedAtDesc(String string, Pageable pageable);
	public Page<Store> findByNameLikeOrderByPriceDesc(String string, Pageable pageable);
	public Page<Store> findByCategory_NameOrderByPriceDesc(String category, Pageable pageable);
	public Page<Store> findByPriceLessThanEqualOrderByPriceDesc(Integer price, Pageable pageable);
	public Page<Store> findAllByOrderByPriceDesc(Pageable pageable);
 


}



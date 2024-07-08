package com.example.nagoyameshi.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
 @Entity
 @Table(name = "stores")
 @Data
public class Store {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer id;
    
     
 	@ManyToOne
 	@JoinColumn(name = "category_id")
 	private Category category;
 	
     @Column(name = "name")
     private String name;
 
     @Column(name = "image_name")
     private String imageName;
     
     @Column(name = "price")
     private Integer price;
 
     @Column(name = "description")
     private String description;
 
     @Column(name = "postal_code")
     private String postalCode;
 
     @Column(name = "address")
     private String address;
     
     @Column(name = "business_hours")
     private String businessHours;
 
     @Column(name = "phone_number")
     private String phoneNumber;
 
     @Column(name = "created_at", insertable = false, updatable = false)
     private Timestamp createdAt;
 
     @Column(name = "updated_at", insertable = false, updatable = false)
     private Timestamp updatedAt;
     
     @OneToMany(mappedBy = "store")
     private Set<Favorite> favorites;
     
     @OneToMany(mappedBy = "store")
     private Set<Review> review;
     
}
 
 
 
 
 
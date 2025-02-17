package com.example.nagoyameshi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "review")
@Data

public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	 
 	@ManyToOne
 	@JoinColumn(name = "store_id", nullable = false)
 	private Store store;
 	
 	@ManyToOne
 	@JoinColumn(name = "user_id", nullable = false)
 	private User user;
 	
 	 @Column(name = "review_comment", nullable = false)
     private String reviewComment;
 	 
 	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;     

}

package com.example.nagoyameshi.form;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRegisterForm {
	private Integer storeId;
    
    private Integer userId;    
        
    private LocalDate reservationDate;
    
    private LocalTime reservationTime;  
        
    private Integer numberOfPeople;
    
}

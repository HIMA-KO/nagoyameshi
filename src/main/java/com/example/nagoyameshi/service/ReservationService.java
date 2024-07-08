package com.example.nagoyameshi.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.StoreRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;  
    private final StoreRepository storeRepository;  
    private final UserRepository userRepository;  
    
    public ReservationService(ReservationRepository reservationRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;  
        this.storeRepository = storeRepository;  
        this.userRepository = userRepository;  
    }    
    
    @Transactional
    public void create(ReservationRegisterForm reservationRegisterForm) { 
        Reservation reservation = new Reservation();
        Store store = storeRepository.getReferenceById(reservationRegisterForm.getStoreId());
        User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
        LocalDate reservationDate = reservationRegisterForm.getReservationDate();
        LocalTime reservationTime = reservationRegisterForm.getReservationTime();
         
                
        reservation.setStore(store);
        reservation.setUser(user);
        reservation.setReservationDate(reservationDate);
        reservation.setReservationTime(reservationTime);
        reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
        
        reservationRepository.save(reservation);
    } 
	
	
//	// 宿泊人数が定員以下かどうかをチェックする
//    public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
//        return numberOfPeople <= capacity;
//    }
//    
//    // 宿泊料金を計算する
//    public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
//        long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
//        int amount = price * (int)numberOfNights;
//        return amount;
//    } 

}

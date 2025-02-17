package com.example.nagoyameshi.service;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Store;
import com.example.nagoyameshi.form.StoreEditForm;
import com.example.nagoyameshi.form.StoreRegisterForm;
import com.example.nagoyameshi.repository.StoreRepository;
 
 @Service
 public class StoreService {
     private final StoreRepository StoreRepository;    
     
     public StoreService(StoreRepository StoreRepository) {
         this.StoreRepository = StoreRepository;        
     }    
     
     @Transactional
     public void create(StoreRegisterForm StoreRegisterForm) {
         Store Store = new Store();        
         MultipartFile imageFile = StoreRegisterForm.getImageFile();
         
         if (!imageFile.isEmpty()) {
             String imageName = imageFile.getOriginalFilename(); 
             String hashedImageName = generateNewFileName(imageName);
             Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
             copyImageFile(imageFile, filePath);
             Store.setImageName(hashedImageName);
         }
         
         Store.setName(StoreRegisterForm.getName());
         Store.setPrice(StoreRegisterForm.getPrice()); 
         Store.setDescription(StoreRegisterForm.getDescription());
         Store.setPostalCode(StoreRegisterForm.getPostalCode());
         Store.setAddress(StoreRegisterForm.getAddress());
         Store.setBusinessHours(StoreRegisterForm.getBusinessHours());
         Store.setPhoneNumber(StoreRegisterForm.getPhoneNumber());
                     
         StoreRepository.save(Store);
     }
     
     @Transactional
     public void update(StoreEditForm storeEditForm) {
         Store store = StoreRepository.getReferenceById(storeEditForm.getId());
         MultipartFile imageFile = storeEditForm.getImageFile();
         
         if (!imageFile.isEmpty()) {
             String imageName = imageFile.getOriginalFilename(); 
             String hashedImageName = generateNewFileName(imageName);
             Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
             copyImageFile(imageFile, filePath);
             store.setImageName(hashedImageName);
         }
         
         store.setName(storeEditForm.getName());
         store.setPrice(storeEditForm.getPrice());  
         store.setDescription(storeEditForm.getDescription());
         store.setPostalCode(storeEditForm.getPostalCode());
         store.setAddress(storeEditForm.getAddress());
         store.setBusinessHours(storeEditForm.getBusinessHours());
         store.setPhoneNumber(storeEditForm.getPhoneNumber());
                     
         StoreRepository.save(store);
     }    
     
     // UUIDを使って生成したファイル名を返す
     public String generateNewFileName(String fileName) {
         String[] fileNames = fileName.split("\\.");                
         for (int i = 0; i < fileNames.length - 1; i++) {
             fileNames[i] = UUID.randomUUID().toString();            
         }
         String hashedFileName = String.join(".", fileNames);
         return hashedFileName;
     }     
     
     // 画像ファイルを指定したファイルにコピーする
     public void copyImageFile(MultipartFile imageFile, Path filePath) {           
         try {
             Files.copy(imageFile.getInputStream(), filePath);
         } catch (IOException e) {
             e.printStackTrace();
         }          
     }
     
    
 }

 
 
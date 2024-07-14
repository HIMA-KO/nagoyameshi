package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nagoyameshi.entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    static PasswordResetToken findByToken(String token) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


//	void save(PasswordResetToken myToken);
}

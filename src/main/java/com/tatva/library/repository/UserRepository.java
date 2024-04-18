package com.tatva.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.library.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);
	
}

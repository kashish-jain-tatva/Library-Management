package com.tatva.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatva.library.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);
	
}

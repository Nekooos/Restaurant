package com.rest.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.practice.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User save(User user);
	
	User findByUsername(String username);

	void deleteById(Long id);
}

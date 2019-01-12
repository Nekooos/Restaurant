package com.rest.practice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.practice.models.User;

import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT m FROM User m WHERE username = :username")
    Optional<User> findByUsername(String username);
}

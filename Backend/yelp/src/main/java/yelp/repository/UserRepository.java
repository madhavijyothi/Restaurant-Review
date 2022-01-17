package yelp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yelp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//We return an optional, in the service we need to handle it
	//Select * from User where id = :id
	Optional<User> findById(Long id);
	
	//Select * from user where email = :email
	Optional<User> findByEmail(String email);
	
}

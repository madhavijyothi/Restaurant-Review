package yelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yelp.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	//Select * from Restaurant where id = :id
	Restaurant findById(Long id);
	
	//Select * from Restaurant where name like :name
	List <Restaurant> findByNameContaining (String searchName);

}

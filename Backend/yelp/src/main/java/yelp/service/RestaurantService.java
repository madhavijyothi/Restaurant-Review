package yelp.service;

import java.util.List;

import yelp.domain.Restaurant;
import yelp.domain.Review;

public interface RestaurantService {

	Restaurant findById(Long id);
	
	List <Restaurant> findAll();
	
	List <Restaurant> findRestaurantByName(String searchName);
	
	void addReview(Long id, Review review);
}

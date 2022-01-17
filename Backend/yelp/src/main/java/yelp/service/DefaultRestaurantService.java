package yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yelp.domain.Restaurant;
import yelp.domain.Review;
import yelp.repository.RestaurantRepository;


@Transactional(readOnly = true)
@Service
public class DefaultRestaurantService implements RestaurantService {

	private final RestaurantRepository restaurantRepository;
	
	@Autowired
	public DefaultRestaurantService (RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	@Override
	public List<Restaurant> findAll() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> findRestaurantByName(String searchName) {
		return this.restaurantRepository.findByNameContaining(searchName);
	}

	@Override
	public Restaurant findById(Long id) {
		return this.restaurantRepository.findById(id);
	}

	@Override
	public void addReview(Long id, Review review) {
		Restaurant restaurant = this.findById(id);
		restaurant.getReviews().add(review);
	}

}

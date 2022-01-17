package yelp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yelp.AbstractYelpIntegrationTests;
import yelp.domain.Restaurant;
import yelp.domain.Review;
import yelp.domain.User;
import yelp.repository.ReviewRepository;

public class RestaurantServiceTest extends AbstractYelpIntegrationTests {

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewRepository reviewRepository;

	
	@Test
	public void findAll(){
		assertThat(restaurantService.findAll().size()).isEqualTo(3);		
	}
	
	@Test
	public void findById(){
		assertThat(restaurantService.findById(1L).getName()).isEqualTo("testRestaurantName");
	}
	
	@Test
	public void findByRestaurantName(){
		assertThat(restaurantService.findRestaurantByName("2").size()).isEqualTo(1);
		assertThat(restaurantService.findRestaurantByName("testRestaurantName").size()).isEqualTo(3);
	}
	
	@Test
	public void addReview() {
		assertThat(reviewRepository.count()).isEqualTo(3);
		
		//Get user and restaurant
		User user = userService.findById(1L); 
		Restaurant restaurant = restaurantService.findById(1L); 
		
		//Check restaurant list
		assertThat(restaurant.getReviews().size()).isEqualTo(1);
		
		//Create review
		Review review = new Review("something text1..", 3, LocalDateTime.now(), user, restaurant);
		restaurantService.addReview(restaurant.getId(), review);
		assertThat(reviewRepository.count()).isEqualTo(4);

		//Check the restaurant list
		assertThat(restaurant.getReviews().size()).isEqualTo(2);
		
	}
}

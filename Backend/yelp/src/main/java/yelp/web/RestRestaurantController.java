package yelp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import yelp.domain.JsonViews;
import yelp.domain.Restaurant;
import yelp.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestRestaurantController {

	RestaurantService restaurantService;
	
	@Autowired
	public RestRestaurantController (RestaurantService restaurantService){
		this.restaurantService = restaurantService;
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<Restaurant> retrieveAllRestaurants (){
		return restaurantService.findAll();
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping("/{id}")
	public Restaurant retrieveRestaurantById (@PathVariable Long id){
		return restaurantService.findById(id);
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping("/search/{name}")
	public List<Restaurant> retrieveRestaurantById (@PathVariable String name){
		return restaurantService.findRestaurantByName(name);
	}
	
}

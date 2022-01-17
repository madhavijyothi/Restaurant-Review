package yelp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantDomainTest {

	@Test
	public void createRestaurant() {
		Restaurant rest1 = new Restaurant("El Galo", "pepe, 8", "asd@asd.com", "123456789", "logo.jpg", "www.lamacarena.com", null);
		assertEquals("123456789", rest1.getPhone());
	}
	
}

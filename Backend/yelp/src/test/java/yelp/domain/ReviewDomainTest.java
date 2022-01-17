package yelp.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;


public class ReviewDomainTest {
	
	@Test
	public void createReview() {
		
		Restaurant rest1 = new Restaurant("Test Restaurant Name", "pepe, 8", "asd@asd.com", "123456789", "logo.jpg", "www.lamacarena.com", null);
		assertEquals("123456789", rest1.getPhone());
		Review rev1 = new Review("irgendwas text1..", 3, LocalDateTime.now(), new User(), rest1);
		Review rev2 = new Review("irgendwas text2..", 4, LocalDateTime.now(), new User(), rest1);
		Review rev3 = new Review("irgendwas text3..", 2, LocalDateTime.now(), new User(), rest1);
		assertEquals("irgendwas text1..", rev1.getContent());
		assertEquals(2, rev3.getRate());
		assertEquals("asd@asd.com", rev2.getRestaurant().getEmail());
	}

}

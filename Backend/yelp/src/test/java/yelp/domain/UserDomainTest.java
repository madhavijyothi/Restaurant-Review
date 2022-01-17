package yelp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserDomainTest {

	@Test
	public void createUser() {
		User rest1 = new User("Miguel", "Perello", "popopo@pepepe.com", "caperucita", "123");
		assertEquals("popopo@pepepe.com", rest1.getEmail());
	}
}

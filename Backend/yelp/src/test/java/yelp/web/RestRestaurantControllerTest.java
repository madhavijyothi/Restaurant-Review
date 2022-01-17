package yelp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import yelp.AbstractYelpWebIntegrationTests;

public class RestRestaurantControllerTest extends AbstractYelpWebIntegrationTests  {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void retrieveAllRestaurants() throws Exception {
		mockMvc.perform(get("/restaurants").accept(APPLICATION_JSON))//
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
				.andExpect(status().isOk())//
				.andExpect(jsonPath("$[2]").exists())
				.andExpect(jsonPath("$[3]").doesNotExist())
				// Exists one restaurant with the name testRestaurantName
				.andExpect(jsonPath("$[*].name", hasItems("testRestaurantName"))
		);
	}
	
	@Test
	public void retrieveRestaurantById() throws Exception {
		mockMvc.perform(get("/restaurants/1").accept(APPLICATION_JSON))
			.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("testRestaurantName"))
		);
	}
	
	@Test
	public void retrieveRestaurantsByName() throws Exception {
		mockMvc.perform(get("/restaurants/search/2").accept(APPLICATION_JSON))
		.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name", is("testRestaurantName2"))
	);
	}
}

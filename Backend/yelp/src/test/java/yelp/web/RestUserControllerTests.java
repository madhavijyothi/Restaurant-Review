package yelp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import yelp.AbstractYelpWebIntegrationTests;
import yelp.repository.UserRepository;

/**
 * Integration tests for the {@link RestUserController}.
 */
public class RestUserControllerTests extends AbstractYelpWebIntegrationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserRepository repo;

	

}
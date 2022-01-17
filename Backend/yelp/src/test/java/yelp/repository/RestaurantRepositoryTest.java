package yelp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yelp.AbstractYelpIntegrationTests;

public class RestaurantRepositoryTest extends AbstractYelpIntegrationTests {

	@Autowired
	RestaurantRepository repository;
	
	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(3);
	}
	
	@Test
	public void findById(){
		assertThat(repository.findById(1L).getName()).isEqualTo("testRestaurantName");
	}
	
	@Test
	public void findAll(){
		assertThat(repository.findAll().size()).isEqualTo((int) repository.count());		
	}
	
	@Test
	public void findByRestaurantName(){
		assertThat(repository.findByNameContaining("2").size()).isEqualTo(1);
		assertThat(repository.findByNameContaining("testRestaurantName").size()).isEqualTo(3);
	}
}

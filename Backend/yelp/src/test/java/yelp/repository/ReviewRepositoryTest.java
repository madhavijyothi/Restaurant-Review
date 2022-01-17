package yelp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yelp.AbstractYelpIntegrationTests;
import yelp.domain.Review;

public class ReviewRepositoryTest extends AbstractYelpIntegrationTests{

	@Autowired
	ReviewRepository repository;
	
	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(3);
		assertThat(repository.findAll().size()).isEqualTo(3);		
	}
	
	
	@Test
	public void findById(){
		assertThat(repository.findById(2L).getContent()).isEqualTo("irgendwas text2..");
		
	}
}

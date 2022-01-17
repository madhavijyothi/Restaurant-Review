package yelp.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yelp.domain.User;
import yelp.AbstractYelpIntegrationTests;

public class UserRepositoryTest extends AbstractYelpIntegrationTests{

	@Autowired
	UserRepository repository;
	
	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(3);
	}
	
	@Test
	public void findById() {
		Long id = repository.findById(1L).get().getId();
		assertThat(repository.findById(id)).isPresent();
		assertThat(repository.findById(999999L)).isNotPresent();
	}
	
	@Test
	public void findAll() {
		List<String> firstNames = repository.findAll().stream().map(User::getFirstName).collect(toList());
		assertThat(firstNames).containsExactlyInAnyOrder("testFirstName", "testFirstName2", "testFirstName3");
	}
		
	@Test
	public void save() {
		assertThat(repository.count()).isEqualTo(3);
		User newUser = new User("Miguel", "Perello", "popopo@pepepe.com", "caperucita", "123");
		repository.save(newUser);
		assertThat(repository.count()).isEqualTo(4);
	}
}

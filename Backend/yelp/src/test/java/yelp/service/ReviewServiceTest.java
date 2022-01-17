package yelp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yelp.AbstractYelpIntegrationTests;
import yelp.domain.Restaurant;
import yelp.domain.Review;
import yelp.domain.User;
import yelp.repository.RestaurantRepository;
import yelp.repository.ReviewRepository;
import yelp.repository.UserRepository;

public class ReviewServiceTest extends AbstractYelpIntegrationTests {

	@Autowired
	ReviewService service;

	@Autowired
	ReviewRepository repository;

	@Test
	public void findReviewByIdTest() {
		assertThat(service.findReviewById(1L).getRestaurant().getName()).isEqualTo("testRestaurantName2");
	}

	@Test
	public void editReviewTest() {
		Review review = service.findReviewById(1L);
		assertThat(review.getContent()).isEqualTo("irgendwas text10..");
		review.setContent("new content text..");
		service.editReview(review);
		assertThat(review.getContent()).isNotEqualTo("irgendwas text10..");
		assertThat(review.getContent()).isEqualTo("new content text..");
	}

	@Test
	public void deleteReviewTest() {
		assertThat(repository.count()).isEqualTo(3);
		service.deleteReview(1L);
		assertThat(repository.count()).isEqualTo(2);
	}
}

package yelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yelp.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	// Select * from review where id = :id
	Review findById(Long id);

}

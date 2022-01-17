package yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yelp.domain.Review;
import yelp.repository.ReviewRepository;

@Transactional(readOnly = true)
@Service
public class DefaultReviewService implements ReviewService {

	private final ReviewRepository reviewRepository;

	@Autowired
	public DefaultReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Override
	public Review findReviewById(Long id) {
		return this.reviewRepository.findById(id);
	}

	@Override
	public void editReview(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void deleteReview(Long reviewId) {
		reviewRepository.delete(reviewId);

	}

}

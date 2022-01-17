package yelp.service;

import yelp.domain.Review;

public interface ReviewService {

	Review findReviewById(Long id);

	void editReview(Review review);

	void deleteReview(Long reviewId);

}

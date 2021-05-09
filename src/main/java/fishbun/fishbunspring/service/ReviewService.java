package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Review;
import fishbun.fishbunspring.repository.ReviewRepository;

import java.util.List;

public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save(Review review){
        reviewRepository.insert(review);
        return review;
    }

    public Review modify(Review review){
        reviewRepository.updateReview(review);
        return review;
    }

    public void remove(Review review){
        reviewRepository.deleteReview(review);
    }

    public List<Review> findAll(){
        return reviewRepository.selectAll();
    }

    public Review findById(Integer rev_id){
        return reviewRepository.selectById(rev_id);
    }



}

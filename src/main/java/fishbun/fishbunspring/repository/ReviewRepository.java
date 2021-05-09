package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Review;

import java.util.List;

public interface ReviewRepository {
    Review insert(Review review);

    Review selectById(Integer rev_id);

    List<Review> selectAll();

    Review updateReview(Review review);

    void deleteReview(Review review);
}

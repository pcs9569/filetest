package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Review;
import fishbun.fishbunspring.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //Create
    @PostMapping("")
    @ResponseBody
    public Review create(Integer sto_id, String u_email, String rev_content){
        Review review = new Review();

        review.setSto_id(sto_id);
        review.setU_email(u_email);
        review.setRev_content(rev_content);

        reviewService.save(review);

        return review;
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Review> lists(){
        List<Review> review = reviewService.findAll();
        return review;
    }

    //Read
    @GetMapping("/{rev_id}")
    @ResponseBody
    public Review listReview(@PathVariable Integer rev_id){
        Review review = reviewService.findById(rev_id);
        return review;
    }

    //Update
    @PutMapping("/{rev_id}")
    @ResponseBody
    public Review changeReview(@PathVariable Integer rev_id,
                               @RequestParam(required = false, value = "rev_content") String rev_content){
        Review review = reviewService.findById(rev_id);

        if(rev_content!=null){
            review.setRev_content(rev_content);
        }

        return reviewService.modify(review);
    }

    //Delete
    @DeleteMapping("/{rev_id}")
    @ResponseBody
    public void destroyReview(@PathVariable Integer rev_id){
        Review review = reviewService.findById(rev_id);
        if(review != null){
            reviewService.remove(review);
        }else{
            System.out.println("rev_id에 해당하는 review가 없습니다.");
        }
    }


}

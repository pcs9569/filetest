package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Likes;
import fishbun.fishbunspring.service.LikesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/likes")
public class LikesController {

    private final LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    //Create
    @PostMapping("")
    @ResponseBody
    public Likes create(Integer sto_id, String u_email, Integer likes_press){
        Likes likes = new Likes();
        likes.setSto_id(sto_id);
        likes.setU_email(u_email);
        likes.setLikes_press(likes_press);

        likesService.save(likes);

        return likes;
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Likes> lists(){
        List<Likes> likes = likesService.findAll();
        return likes;
    }

    //Read
    @GetMapping("/{likes_id}")
    @ResponseBody
    public Likes listLikes(@PathVariable Integer likes_id){
        Likes likes = likesService.findById(likes_id);
        return likes;
    }

    //Update
    @PutMapping("/{likes_id}")
    @ResponseBody
    public Likes changeLikes(@PathVariable Integer likes_id,
                             @RequestParam(required = false, value = "likes_press")Integer likes_press){
        Likes likes = likesService.findById(likes_id);

        if(likes_press != null){
            likes.setLikes_press(likes_press);
        }

        return likesService.modify(likes);
    }

    //Delete
    @DeleteMapping("/{likes_id}")
    @ResponseBody
    public void destoryLikes(@PathVariable Integer likes_id){
        Likes likes = likesService.findById(likes_id);

        if(likes != null){
            likesService.remove(likes);
        }else{
            System.out.println("likes_id에 해당하는 likes가 없습니다.");
        }
    }

}

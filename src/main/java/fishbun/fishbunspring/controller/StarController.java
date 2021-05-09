package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Star;
import fishbun.fishbunspring.service.StarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stars")
public class StarController {
    private final StarService starService;

    public StarController(StarService starService){
        this.starService = starService;
    }

    //Create
    @PostMapping("")
    @ResponseBody
    public Star create(Integer sto_id, String u_email, Integer star_point){
        Star star = new Star();
        star.setSto_id(sto_id);
        star.setU_email(u_email);
        star.setStar_point(star_point);

        starService.save(star);

        return star;
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Star> lists(){
        List<Star> star = starService.findAll();
        return star;
    }

    //Read
    @GetMapping("/{star_id}")
    @ResponseBody
    public Star listStar(@PathVariable Integer star_id){
        Star star = starService.findById(star_id);
        return star;
    }

    //Update
    @PutMapping("/{star_id}")
    @ResponseBody
    public Star changeStar(@PathVariable Integer star_id,
                           @RequestParam(required = false, value = "star_point") Integer star_point){
        Star star = starService.findById(star_id);

        if(star_point!=null){
            star.setStar_point(star_point);
        }

        return starService.modify(star);
    }

    //Delete
    @DeleteMapping("/{star_id}")
    @ResponseBody
    public void destroyStar(@PathVariable Integer star_id){
        System.out.println("-------------Controller destory--------");
        System.out.println("Integer star_id : "+star_id);

        Star star = starService.findById(star_id);
        starService.remove(star);
        System.out.println("star.getStar_id() : "+star.getStar_id());

        if(star != null){
            starService.remove(star);
        }else{
            System.out.println("star_id에 해당하는 star가 없습니다.");
        }
    }


}

package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Kind;
import fishbun.fishbunspring.service.KindService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/kinds")
public class KindController {

    private final KindService kindService;

    public KindController(KindService kindService){
        this.kindService = kindService;
    }

    //Create
    @PostMapping("")
    @ResponseBody
    public Kind create(Integer sto_id, String kind_article){
        Kind kind=new Kind();

        kind.setSto_id(sto_id);
        kind.setKind_article(kind_article);
        System.out.println("-----------controller-----------");
        System.out.println(sto_id);
        System.out.println(kind_article);

        kindService.save(kind);
        return kind;
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Kind> lists(){
        List<Kind> kind = kindService.findAll();
        return kind;
    }

    //Read
    @GetMapping("/{kind_id}")
    @ResponseBody
    public Kind listKind(@PathVariable Integer kind_id){
        Kind kind = kindService.findById(kind_id);
        return kind;
    }

    //Update
    @PutMapping("/{kind_id}")
    @ResponseBody
    public Kind changeKind(@PathVariable Integer kind_id, @RequestParam(required = false, value = "kind_article") String kind_article){
        Kind kind = kindService.findById(kind_id);

        if(kind_article!=null){
            kind.setKind_article(kind_article);
        }

        return kindService.modify(kind);
    }

    //Delete
    @DeleteMapping("/{kind_id}")
    @ResponseBody
    public void destroyKind(@PathVariable Integer kind_id){
        Kind kind = kindService.findById(kind_id);
        if(kind != null){
            kindService.remove(kind);
        }else{
            System.out.println("kind_id에 해당하는 kind가 없습니다.");
        }
    }

}

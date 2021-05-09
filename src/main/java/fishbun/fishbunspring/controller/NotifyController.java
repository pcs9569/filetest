package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Notify;
import fishbun.fishbunspring.service.NotifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/notifies")
public class NotifyController {
    private final NotifyService notifyService;

    public NotifyController(NotifyService notifyService){
        this.notifyService = notifyService;
    }

    //Create
    @PostMapping("")
    @ResponseBody
    public Notify create(Integer sto_id, String u_email, String noti_content, Integer noti_type){
        Notify notify = new Notify();

        notify.setSto_id(sto_id);
        notify.setU_email(u_email);
        notify.setNoti_content(noti_content);
        notify.setNoti_type(noti_type);

        notifyService.save(notify);

        return notify;
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Notify> lists(){
        List<Notify> notify = notifyService.findAll();
        return notify;
    }

    //Read
    @GetMapping("/{noti_id}")
    @ResponseBody
    public Notify listNotify(@PathVariable Integer noti_id){
        Notify notify = notifyService.findById(noti_id);
        return notify;
    }

    //Update
    @PutMapping("/{noti_id}")
    @ResponseBody
    public Notify changeNotify(@PathVariable Integer noti_id,
                               @RequestParam(required = false, value ="noti_content") String noti_content,
                               @RequestParam(required = false, value="noti_type") Integer noti_type
                               ){
        Notify notify = notifyService.findById(noti_id);

        if(noti_content!=null){
            notify.setNoti_content(noti_content);
        }
        if(noti_type!=null){
            notify.setNoti_type(noti_type);
        }

        return notifyService.modify(notify);
    }

    //Delete
    @DeleteMapping("/{noti_id}")
    @ResponseBody
    public void destroyNotify(@PathVariable Integer noti_id){
        Notify notify = notifyService.findById(noti_id);
        if(notify != null){
            notifyService.remove(notify);
        }else{
            System.out.println("noti_id에 해당하는 notify가 없습니다.");
        }
    }

}

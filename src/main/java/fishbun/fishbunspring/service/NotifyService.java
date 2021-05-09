package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Notify;
import fishbun.fishbunspring.repository.NotifyRepository;

import java.util.List;

public class NotifyService {

    private final NotifyRepository notifyRepository;

    public NotifyService(NotifyRepository notifyRepository){
        this.notifyRepository = notifyRepository;
    }

    public Notify save(Notify notify){
        notifyRepository.insert(notify);
        return notify;
    }

    public List<Notify> findAll(){
        return notifyRepository.selectAll();
    }

    public Notify findById(Integer noti_id){
        return notifyRepository.selectById(noti_id);
    }

    public Notify modify(Notify notify){
        notifyRepository.updateNotify(notify);
        return notify;
    }

    public void remove(Notify notify){
        notifyRepository.deleteNotify(notify);
    }

}

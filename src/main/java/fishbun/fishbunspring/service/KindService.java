package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Kind;
import fishbun.fishbunspring.repository.KindRepository;

import java.util.List;

public class KindService {
    private final KindRepository kindRepository;
    public KindService(KindRepository kindRepository){
        this.kindRepository = kindRepository;
    }

    public Kind save(Kind kind){
        System.out.println("-----------Service-----------");
        System.out.println(kind.getSto_id());
        System.out.println(kind.getKind_article());
        kindRepository.insert(kind);
        return kind;
    }

    public Kind modify(Kind kind){
        kindRepository.updateKind(kind);
        return kind;
    }

    public void remove(Kind kind){
        kindRepository.deleteKind(kind);
    }

    public List<Kind> findAll(){
        return kindRepository.selectAll();
    }

    public Kind findById(Integer kind_id){
        return kindRepository.selectById(kind_id);
    }




}

package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Likes;
import fishbun.fishbunspring.repository.LikesRepository;

import java.util.List;

public class LikesService {

    private final LikesRepository likesRepository;
    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public Likes save(Likes likes){
        likesRepository.insert(likes);
        return likes;
    }

    public Likes modify(Likes likes){
        likesRepository.updateLikes(likes);
        return likes;
    }

    public void remove(Likes likes){
        likesRepository.deleteLikes(likes);
    }

    public List<Likes> findAll(){
        return likesRepository.selectAll();
    }

    public Likes findById(Integer likes_id){
        return likesRepository.selectById(likes_id);
    }



}

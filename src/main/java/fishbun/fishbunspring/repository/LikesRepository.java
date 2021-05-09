package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Likes;

import java.util.List;

public interface LikesRepository {
    Likes insert(Likes likes);

    Likes selectById(Integer likes_id);

    List<Likes> selectAll();

    Likes updateLikes(Likes likes);

    void deleteLikes(Likes likes);

}

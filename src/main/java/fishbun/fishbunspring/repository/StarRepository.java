package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Star;

import java.util.List;

public interface StarRepository {
    Star insert(Star star);

    Star selectById(Integer star_id);

    List<Star> selectAll();

    Star updateStar(Star star);

    void deleteStar(Star star);
}

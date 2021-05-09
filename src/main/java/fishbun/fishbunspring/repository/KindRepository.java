package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Kind;

import java.util.List;

public interface KindRepository {
    Kind insert(Kind kind);

    Kind selectById(Integer kind_id);

    List<Kind> selectAll();

    void updateKind(Kind kind);

    void deleteKind(Kind kind);
}

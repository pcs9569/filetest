package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Notify;

import java.util.List;

public interface NotifyRepository {
    void insert(Notify notify);

    Notify selectById(Integer notify_id);

    List<Notify> selectAll();

    void updateNotify(Notify notify);

    void deleteNotify(Notify notify);

}

package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Store;

import java.util.List;

public interface StoreRepository {
    Store insert(Store store);

    Store selectById(Integer sto_id);

    List<Store> selectAll();
    Store updateStore(Store store);

    void deleteStore(Store store);
}

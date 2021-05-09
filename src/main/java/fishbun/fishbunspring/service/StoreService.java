package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.Store;
import fishbun.fishbunspring.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StoreService {

    private final StoreRepository storeRepository;


    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store save(Store store){
        storeRepository.insert(store);
        return store;
    }

    public Store modify(Store store){
        storeRepository.updateStore(store);
        return store;
    }

    public void remove(Store store){
        storeRepository.deleteStore(store);
    }

    public List<Store> findAll(){
        return storeRepository.selectAll();
    }

    public Store findById(Integer sto_id){
        return storeRepository.selectById(sto_id);
    }


}

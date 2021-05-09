package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.Store;
import fishbun.fishbunspring.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("")
    @ResponseBody
    public Store create(String sto_name, String sto_picture, String sto_detail_option, Double sto_lat, Double sto_lon){
        Store store = new Store();

        store.setSto_name(sto_name);
        store.setSto_picture(sto_picture);
        store.setSto_detail_option(sto_detail_option);
        store.setSto_lat(sto_lat);
        store.setSto_lon(sto_lon);

        storeService.save(store);

        return store;

    }

    @GetMapping("")
    @ResponseBody
    public List<Store> lists(){
        List<Store> store = storeService.findAll();
        return store;

    }

    @GetMapping("/{sto_id}")
    @ResponseBody
    public Store listStore(@PathVariable Integer sto_id){
        Store store = storeService.findById(sto_id);
        return store;
    }



    @PutMapping("/{sto_id}")
    @ResponseBody
    public Store changeStore(@PathVariable Integer sto_id,
                             @RequestParam(required = false, value = "sto_name") String sto_name,
                             @RequestParam(required = false, value = "sto_picture") String sto_picture,
                             @RequestParam(required = false, value = "sto_detail_option") String sto_detail_option,
                             @RequestParam(required = false, value = "sto_lat") Double sto_lat,
                             @RequestParam(required = false, value = "sto_lon") Double sto_lon
                             ){
        Store store = storeService.findById(sto_id);

        if(sto_name != null){
            store.setSto_name(sto_name);
        }

        if(sto_picture != null){
            store.setSto_picture(sto_picture);
        }

        if(sto_detail_option != null){
            store.setSto_detail_option(sto_detail_option);
        }

        if(sto_lat != null){
            store.setSto_lat(sto_lat);
        }

        if(sto_lon != null){
            store.setSto_lon(sto_lon);
        }

        return storeService.modify(store);
    }

    @DeleteMapping("/{sto_id}")
    @ResponseBody
    public void destroyStore(@PathVariable Integer sto_id){
        Store store = storeService.findById(sto_id);
        if(store != null) {
            storeService.remove(store);
        }else{
            System.out.println("sto_id에 해당하는 store가 없습니다.");
        }

    }

}

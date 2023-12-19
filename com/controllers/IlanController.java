package ilanaraba.com.controllers;

import ilanaraba.com.entitites.Ilan;
import ilanaraba.com.services.IlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IlanController {
    @Autowired
    private IlanService ilanService;


    @GetMapping("/ilanlar/ilan/{id}")
        public Ilan ilanigetir(@PathVariable Long id){
        return ilanService.ilanigetir(id);
    }

    @GetMapping("/filter")
    public List<Ilan> ilanlarıFiltrele(@RequestParam(name = "marka", required = false) String marka,
                                         @RequestParam(name = "minPrice", required = false) Double minPrice,
                                        @RequestParam(name = "maxPrice", required = false) Double maxPrice,
                                       @RequestParam(name="siralama",required = false,defaultValue = "artan") String siralama

                                        ) {
        List<Ilan> ilanlar = ilanService.ilanlariFiltrele(marka,minPrice,maxPrice,siralama);
        return ilanlar;
    }
    @GetMapping("/ilanlar")
    public List<Ilan> getIlanlarByPage(@RequestParam(name = "totalPages", defaultValue = "1") int page,
                                       @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        Page<Ilan> ilanPage = ilanService.getIlanlarByPage(PageRequest.of(page - 1, pageSize));
        List<Ilan> ilanList = ilanPage.getContent(); // Page içindeki ilanları liste olarak al
        return ilanList; // List<Ilan> türünde ilan listesini döndür
    }


}

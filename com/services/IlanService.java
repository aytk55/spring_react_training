package ilanaraba.com.services;

import ilanaraba.com.entitites.Ilan;
import ilanaraba.com.repositories.IlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class IlanService {
    @Autowired
    private IlanRepository ilanRepository;
    public List<Ilan> getTumIlanlar() {
        return ilanRepository.findAll();
    }

    public void ilaniKaydet(Ilan ilan) {
        ilanRepository.save(ilan);
    }

    public void ilaniSil(Long id) {
        ilanRepository.deleteById(id);
    }

    public Ilan ilanigetir(Long id) {
        return ilanRepository.findById(id).orElse(null);
    }



    public List<Ilan> ilanlariFiltrele(String marka,Double minPrice, Double maxPrice,String siralama) {

        List<Ilan> ilanlar = new ArrayList<>();
        if (minPrice != null && maxPrice != null && marka != null) {
            // Min fiyat, max fiyat ve marka tümü seçilmişse
            ilanlar=ilanRepository.findByMarkaAndFiyatBetween(marka, minPrice, maxPrice);
        } else if (minPrice != null && maxPrice != null) {
            // Sadece fiyat aralığı seçilmişse
            ilanlar= ilanRepository.findByFiyatBetween(minPrice, maxPrice);
        } else if (marka!=null) {
            // Sadece marka seçilmişse
            ilanlar=ilanRepository.findByMarka(marka);

        } else if(marka==null) {
            // Hiçbir filtre seçilmemişse, tüm ürünleri getir
            ilanlar= ilanRepository.findAll();
        }
        else{
          return ilanlar;

        }
        if (siralama.equals("artan")) {
            ilanlar.sort(Comparator.comparing(Ilan::getFiyat));
        } else if (siralama.equals("azalan")) {
            ilanlar.sort(Comparator.comparing(Ilan::getFiyat).reversed());
        }

        return ilanlar;
    }


    public Page<Ilan> getIlanlarByPage(PageRequest pageRequest) {

        Page<Ilan> ilanlar = ilanRepository.findAll(pageRequest);
        return ilanlar;
    }
}

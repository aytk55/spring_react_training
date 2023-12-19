package ilanaraba.com.repositories;
import ilanaraba.com.entitites.Ilan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IlanRepository extends JpaRepository<Ilan,Long> {

    List<Ilan> findByMarka(String marka);
    List<Ilan> findByMarkaAndFiyatBetween(String marka, double minPrice, double maxPrice);

    List<Ilan> findByFiyatBetween(double minFiyat, double maxFiyat);
}

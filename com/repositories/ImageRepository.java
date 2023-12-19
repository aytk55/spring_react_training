package ilanaraba.com.repositories;

import ilanaraba.com.entitites.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}

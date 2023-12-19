package ilanaraba.com.services;

import ilanaraba.com.entitites.Image;
import ilanaraba.com.repositories.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
    }
    public void save(Image image){
        imageRepository.save(image);
    }
}

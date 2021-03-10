package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.model.Image;
import sam.ecommerce.bookstore.repository.ImageRepository;
import sam.ecommerce.bookstore.service.ImageService;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class DefaultImageService implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public UUID uploadImage(Image image) {
        return imageRepository.save(image).getCode();
    }

    @Override
    public Image getImage(UUID imageCode) {
        return imageRepository.findByCode(imageCode).orElseThrow(EntityNotFoundException::new);
    }
}

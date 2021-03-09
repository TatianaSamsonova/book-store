package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.exception.ImageUploadException;
import sam.ecommerce.bookstore.model.Image;
import sam.ecommerce.bookstore.repository.ImageRepository;
import sam.ecommerce.bookstore.service.ImageService;

@Service
public class DefaultImageService implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void uploadImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Image getImage() {
        Image image = imageRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new ImageUploadException("Image repository is empty"));
        imageRepository.deleteById(image.getId());
        return image;
    }
}

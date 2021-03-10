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
        return imageRepository.findAll()
                .stream()
                .filter(image -> image.getBook() == null)
                .findFirst()
                .orElseThrow(() -> new ImageUploadException("There is no free image"));
    }
}

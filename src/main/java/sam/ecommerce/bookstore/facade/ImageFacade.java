package sam.ecommerce.bookstore.facade;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageFacade {
    UUID uploadImage(MultipartFile multipartFile);
}

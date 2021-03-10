package sam.ecommerce.bookstore.facade;

import org.springframework.web.multipart.MultipartFile;

public interface ImageFacade {
    void uploadImage(MultipartFile multipartFile);
}

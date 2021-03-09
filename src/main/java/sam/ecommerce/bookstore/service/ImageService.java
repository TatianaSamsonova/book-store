package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.model.Image;

public interface ImageService {
    void uploadImage(Image image);
    Image getImage();
}

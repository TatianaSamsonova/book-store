package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.model.Image;

import java.util.UUID;

public interface ImageService {
    UUID uploadImage(Image image);
    Image getImage(UUID imageId);
}

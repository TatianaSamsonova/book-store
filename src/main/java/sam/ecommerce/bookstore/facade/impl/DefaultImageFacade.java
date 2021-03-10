package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.converter.ImageConverter;
import sam.ecommerce.bookstore.exception.ImageUploadException;
import sam.ecommerce.bookstore.facade.ImageFacade;
import sam.ecommerce.bookstore.model.Image;
import sam.ecommerce.bookstore.service.ImageService;

@Component
public class DefaultImageFacade implements ImageFacade {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private ImageService imageService;

    @Override
    public void uploadImage(MultipartFile file) throws ImageUploadException {
        Image image = imageConverter.convert(file);
        try{
            if (image.getBytes().length != 0){
                imageService.uploadImage(image);
            }
        } catch (NullPointerException e){
            throw new ImageUploadException("This image cannot be uploaded");
        }
    }
}

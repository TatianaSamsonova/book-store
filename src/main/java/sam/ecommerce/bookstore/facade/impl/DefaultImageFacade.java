package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.converter.ImageConverter;
import sam.ecommerce.bookstore.exception.ImageUploadException;
import sam.ecommerce.bookstore.facade.ImageFacade;
import sam.ecommerce.bookstore.model.Image;
import sam.ecommerce.bookstore.service.ImageService;

import java.util.UUID;

@Component
public class DefaultImageFacade implements ImageFacade {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private ImageService imageService;

    @Override
    public UUID uploadImage(MultipartFile multipartFile) throws ImageUploadException {
        try{
            Image image = imageConverter.convert(multipartFile);
            if (image.getBytes().length != 0){
                return imageService.uploadImage(image);
            }
        } catch (Exception e){
            throw new ImageUploadException("This image cannot be uploaded");
        }
        return null;
    }
}

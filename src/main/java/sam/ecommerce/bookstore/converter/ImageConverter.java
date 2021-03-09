package sam.ecommerce.bookstore.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.model.Image;

import java.io.IOException;

@Component
public class ImageConverter implements Converter<MultipartFile, Image> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageConverter.class);

    @Override
    public Image convert(MultipartFile multipartFile) {
        Image image = new Image();

        try {
            image.setBytes(multipartFile.getBytes());
        } catch (IOException e) {
           LOGGER.warn("Upload image Error");
        }
        return image;
    }
}

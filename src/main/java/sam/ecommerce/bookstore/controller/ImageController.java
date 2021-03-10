package sam.ecommerce.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.facade.ImageFacade;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( "api/images")
public class ImageController {
    @Autowired
    private ImageFacade imageFacade;

    @PostMapping("/upload")
    public UUID uploadImage(@RequestParam("imageFile") MultipartFile file){
        return imageFacade.uploadImage(file);
    }
}

package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.converter.BookConverter;
import sam.ecommerce.bookstore.converter.BookDtoConverter;
import sam.ecommerce.bookstore.converter.ImageConverter;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.exception.ImageUploadException;
import sam.ecommerce.bookstore.facade.BookFacade;
import sam.ecommerce.bookstore.model.Image;
import sam.ecommerce.bookstore.service.BookService;
import sam.ecommerce.bookstore.service.ImageService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultBookFacade implements BookFacade {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private BookDtoConverter bookDtoConverter;
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private ImageService imageService;

    @Override
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(bookConverter::convert)
                .collect(Collectors.toList());
    }

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

    @Override
    public void createBook(BookDto bookDto) {
        bookService.createBook(bookDtoConverter.convert(bookDto));
    }
}

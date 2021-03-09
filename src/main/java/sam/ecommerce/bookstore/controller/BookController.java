package sam.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.facade.BookFacade;
import sam.ecommerce.bookstore.model.Book;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( "api/books")
public class BookController {

    @Autowired
    private BookFacade bookFacade;

    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookFacade.getAllBooks();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        bookFacade.uploadImage(file);
    }

    @PostMapping("/add")
    public void createBook(@RequestBody BookDto bookDto) throws IOException {
       bookFacade.createBook(bookDto);
    }
}

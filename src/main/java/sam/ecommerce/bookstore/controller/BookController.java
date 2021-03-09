package sam.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.facade.BookFacade;

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
}

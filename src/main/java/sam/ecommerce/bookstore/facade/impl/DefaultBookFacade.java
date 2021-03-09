package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.converter.BookConverter;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.facade.BookFacade;
import sam.ecommerce.bookstore.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultBookFacade implements BookFacade {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(bookConverter::convert)
                .collect(Collectors.toList());
    }
}

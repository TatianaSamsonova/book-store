package sam.ecommerce.bookstore.facade;

import sam.ecommerce.bookstore.dto.BookDto;

import java.util.List;

public interface BookFacade {
    List<BookDto> getAllBooks();
    void createBook(BookDto bookDto);
    BookDto deleteBook(long id);
}


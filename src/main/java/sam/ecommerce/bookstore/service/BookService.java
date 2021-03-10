package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void createBook(Book book);
    Book deleteBook(long id);
}

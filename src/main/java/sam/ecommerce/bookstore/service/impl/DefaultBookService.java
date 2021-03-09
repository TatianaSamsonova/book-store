package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.model.Book;
import sam.ecommerce.bookstore.repository.BookRepository;
import sam.ecommerce.bookstore.service.BookService;

import java.util.List;

@Service
public class DefaultBookService implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

}

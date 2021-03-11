package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.model.Book;
import sam.ecommerce.bookstore.repository.BookRepository;
import sam.ecommerce.bookstore.service.BookService;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Book deleteBook(long id) {
        Book book = getBookFromDB(id);
        bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book updateBook(BookDto bookDto) {
        Book book = getBookFromDB(bookDto.getId());
        Book updatedBook = updateBookFields(book, bookDto);
        return bookRepository.save(updatedBook);
    }

    @Override
    public Book getBook(long id) {
        return getBookFromDB(id);
    }

    private Book updateBookFields(Book book, BookDto bookDto){
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    private Book getBookFromDB(long id){
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Book with ID %s doesn't exist", id)));
    }
}

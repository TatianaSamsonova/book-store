package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.model.Book;

@Component
public class BookConverter implements Converter<Book, BookDto> {
    @Override
    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setPicByte(book.getImage());

        return bookDto;
    }
}

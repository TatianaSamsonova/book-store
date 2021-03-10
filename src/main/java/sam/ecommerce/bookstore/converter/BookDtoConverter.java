package sam.ecommerce.bookstore.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.BookDto;
import sam.ecommerce.bookstore.model.Book;
import sam.ecommerce.bookstore.service.ImageService;

@Component
public class BookDtoConverter implements Converter<BookDto, Book> {

    @Autowired
    private ImageService imageService;

    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();

        book.setId(bookDto.getId());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        book.setName(bookDto.getName());
        book.setImage(imageService.getImage(bookDto.getImageCode()));

        return book;
    }
}

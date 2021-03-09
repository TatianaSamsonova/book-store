package sam.ecommerce.bookstore.facade;

import org.springframework.web.multipart.MultipartFile;
import sam.ecommerce.bookstore.dto.BookDto;

import java.io.IOException;
import java.util.List;

public interface BookFacade {
    List<BookDto> getAllBooks();
    void uploadImage(MultipartFile file) throws IOException;
    void createBook(BookDto bookDto);
}


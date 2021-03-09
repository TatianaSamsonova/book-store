package sam.ecommerce.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ecommerce.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

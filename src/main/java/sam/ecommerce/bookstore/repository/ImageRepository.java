package sam.ecommerce.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ecommerce.bookstore.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

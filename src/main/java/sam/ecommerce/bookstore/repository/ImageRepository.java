package sam.ecommerce.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ecommerce.bookstore.model.Image;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByCode(UUID code);
}

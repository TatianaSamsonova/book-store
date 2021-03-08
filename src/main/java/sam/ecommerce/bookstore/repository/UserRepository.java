package sam.ecommerce.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ecommerce.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

package sam.ecommerce.bookstore.service;
import sam.ecommerce.bookstore.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerNewUser(User user);
    User deleteUser(long id);
    User getUser(long id);
    User updateUserInfo(User user, long id);
}

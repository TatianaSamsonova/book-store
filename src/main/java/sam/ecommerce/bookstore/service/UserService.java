package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
}

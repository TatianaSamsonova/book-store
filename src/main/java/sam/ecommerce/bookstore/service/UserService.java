package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    User deleteUser(long id);
    User getUser(long id);
    User updateUserInfo(UserDto userDto);
}

package sam.ecommerce.bookstore.facade;

import sam.ecommerce.bookstore.dto.UserDto;

import java.util.List;

public interface UserFacade {
    List<UserDto> getAllUsers();
    void createUser(UserDto userDto);
}

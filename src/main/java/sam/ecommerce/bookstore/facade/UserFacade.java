package sam.ecommerce.bookstore.facade;

import sam.ecommerce.bookstore.dto.UserUpdateInfoDto;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.dto.UserRegistrationDto;

import java.util.List;

public interface UserFacade {
    List<UserDto> getAllUsers();
    UserDto deleteUser(long id);
    UserDto getUser(long id);
    UserDto updateUserInfo(UserUpdateInfoDto userUpdateInfoDto, long id);
    UserDto registerNewUser(UserRegistrationDto userRegistrationDto);
}

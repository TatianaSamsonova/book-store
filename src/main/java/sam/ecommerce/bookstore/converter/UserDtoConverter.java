package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.exception.InvalidDataException;
import sam.ecommerce.bookstore.model.Role;
import sam.ecommerce.bookstore.model.User;

import java.util.Arrays;

@Component
public class UserDtoConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRole(convertToRole(userDto.getRole()));

        return user;
    }

    private Role convertToRole(String userRole){
        return Arrays.stream(Role.values())
                .filter(value -> value.getName().equals(userRole))
                .findFirst()
                .orElseThrow(() -> new InvalidDataException("This Role doesn't exist. Role: " + userRole, "User Role"));
    }
}

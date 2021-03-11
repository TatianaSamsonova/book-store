package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.UserRegistrationDto;
import sam.ecommerce.bookstore.exception.InvalidDataException;
import sam.ecommerce.bookstore.model.Role;
import sam.ecommerce.bookstore.model.User;

import java.util.Arrays;

@Component
public class UserRegistrationDtoConverter implements Converter<UserRegistrationDto, User> {
    @Override
    public User convert(UserRegistrationDto userRegistrationDto) {
        User user = new User();

        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setPassword(userRegistrationDto.getPassword());
        user.setEmail(userRegistrationDto.getEmail());
        user.setRole(convertToRole(userRegistrationDto.getRole()));

        return user;
    }

    private Role convertToRole(String userRole){
        return Arrays.stream(Role.values())
                .filter(value -> value.getName().equals(userRole))
                .findFirst()
                .orElseThrow(() -> new InvalidDataException("This Role doesn't exist. Role: " + userRole, "User Role"));
    }
}

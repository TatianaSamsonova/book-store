package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.model.User;

@Component
public class UserDtoConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());

        return user;
    }
}

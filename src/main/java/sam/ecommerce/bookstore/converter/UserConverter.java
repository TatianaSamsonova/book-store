package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.model.User;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole().getName());

        return userDto;
    }
}

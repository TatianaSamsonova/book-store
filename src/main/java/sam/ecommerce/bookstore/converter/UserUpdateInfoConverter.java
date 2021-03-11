package sam.ecommerce.bookstore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.dto.UserUpdateInfoDto;
import sam.ecommerce.bookstore.model.User;

@Component
public class UserUpdateInfoConverter implements Converter<UserUpdateInfoDto, User> {
    @Override
    public User convert(UserUpdateInfoDto userUpdateInfoDto) {
        User user = new User();

        user.setFirstName(userUpdateInfoDto.getFirstName());
        user.setLastName(userUpdateInfoDto.getLastName());
        user.setEmail(userUpdateInfoDto.getEmail());
        user.setPassword(userUpdateInfoDto.getPassword());

        return user;
    }
}

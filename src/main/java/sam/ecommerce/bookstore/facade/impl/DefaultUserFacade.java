package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.converter.UserConverter;
import sam.ecommerce.bookstore.converter.UserDtoConverter;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.facade.UserFacade;
import sam.ecommerce.bookstore.service.UserService;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultUserFacade implements UserFacade {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoConverter userDtoConverter;

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(UserDto userDto) {
        userService.createUser(userDtoConverter.convert(userDto));
    }

    @Override
    public UserDto deleteUser(long id) {
        return userConverter.convert(userService.deleteUser(id));
    }
}

package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.converter.UserUpdateInfoConverter;
import sam.ecommerce.bookstore.converter.UserConverter;
import sam.ecommerce.bookstore.converter.UserRegistrationDtoConverter;
import sam.ecommerce.bookstore.dto.UserUpdateInfoDto;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.dto.UserRegistrationDto;
import sam.ecommerce.bookstore.facade.UserFacade;
import sam.ecommerce.bookstore.model.User;
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
    private UserRegistrationDtoConverter userRegistrationDtoConverter;
    @Autowired
    private UserUpdateInfoConverter userUpdateInfoConverter;

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto deleteUser(long id) {
        return userConverter.convert(userService.deleteUser(id));
    }

    @Override
    public UserDto getUser(long id) {
        return userConverter.convert(userService.getUser(id));
    }

    @Override
    public UserDto updateUserInfo(UserUpdateInfoDto userUpdateInfoDto, long id) {
        User userToUpdate = userUpdateInfoConverter.convert(userUpdateInfoDto);
        return userConverter.convert(userService.updateUserInfo(userToUpdate, id));
    }

    @Override
    public UserDto registerNewUser(UserRegistrationDto userRegistrationDto) {
        User userToRegister = userRegistrationDtoConverter.convert(userRegistrationDto);
        User registeredUser = userService.registerNewUser(userToRegister);
        return userConverter.convert(registeredUser);
    }
}

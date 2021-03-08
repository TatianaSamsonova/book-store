package sam.ecommerce.bookstore.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sam.ecommerce.bookstore.converter.UserConverter;
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

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }
}

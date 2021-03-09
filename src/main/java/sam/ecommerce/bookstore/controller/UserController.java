package sam.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.facade.UserFacade;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( "api/users")
public class UserController {
    @Autowired
    private UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userFacade.getAllUsers();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody UserDto userDto){
        userFacade.createUser(userDto);
    }
}

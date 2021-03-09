package sam.ecommerce.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.facade.UserFacade;

import java.util.List;
import javax.validation.Valid;

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
    public void createUser(@RequestBody @Valid UserDto userDto){
        userFacade.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    public UserDto deleteUser(@PathVariable long id){
        return userFacade.deleteUser(id);
    }
}

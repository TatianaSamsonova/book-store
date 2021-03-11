package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.exception.AlreadyExistException;
import sam.ecommerce.bookstore.exception.InvalidDataException;
import sam.ecommerce.bookstore.model.User;
import sam.ecommerce.bookstore.repository.UserRepository;
import sam.ecommerce.bookstore.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        if (user == null){
            throw new InvalidDataException("User to save cannot be null", "User");
        }
        if (userRepository.existsById(user.getId())){
            throw new AlreadyExistException("This User already exists", "User ID " + user.getId());
        }
        userRepository.save(user);
    }

    @Override
    public User deleteUser(long id) {
        User user = getUserFromDB(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User getUser(long id) {
        return getUserFromDB(id);
    }

    @Override
    public User updateUserInfo(UserDto userDto) {
        if (userDto.getName() == null){
            throw new InvalidDataException("User name cannot be null", "User name");
        }
        if (userDto.getPassword() == null){
            throw new InvalidDataException("User password cannot be null", "User password");
        }
        User user = getUserFromDB(userDto.getId());
        User updatedUser = updateUserInfoFields(user, userDto);
        return userRepository.save(updatedUser);
    }

    private User updateUserInfoFields(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private User getUserFromDB(long id){
       return  userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with ID %s doesn't exist", id)));
    }
}

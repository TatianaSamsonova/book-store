package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.dto.UserDto;
import sam.ecommerce.bookstore.exception.AlreadyExistException;
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
            throw new NullPointerException("User to save cannot be null");
        }
        if (userRepository.existsById(user.getId())){
            throw new AlreadyExistException("User already exists. User ID: " + user.getId());
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
        if (userDto.getName() == null || userDto.getPassword() == null){
            throw new NullPointerException("User info cannot be null");
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
       return  userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

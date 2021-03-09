package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.exception.AlreadyExistException;
import sam.ecommerce.bookstore.model.User;
import sam.ecommerce.bookstore.repository.UserRepository;
import sam.ecommerce.bookstore.service.UserService;

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
}

package sam.ecommerce.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public User registerNewUser(User user) {
        if (user == null){
            throw new InvalidDataException("User to save cannot be null", "User");
        }
        String email = user.getEmail();
        if (isEmailExist(email)){
            throw new AlreadyExistException("Account with this email has been already registered", "Email " + email);
        }
        return userRepository.save(user);
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
    public User updateUserInfo(User userToUpdateInfo, long id) {
        User user = getUserFromDB(id);
        String emailToUpdate = userToUpdateInfo.getEmail();

        if (!user.getEmail().equals(emailToUpdate) && isEmailExist(emailToUpdate)) {
            throw new AlreadyExistException("This email already exists in the DB: " + emailToUpdate, "User email");
        }

        User updatedUser = updateUserInfoFields(user, userToUpdateInfo);
        return userRepository.save(updatedUser);
    }

    private boolean isEmailExist(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    private User updateUserInfoFields(User user, User userToUpdateInfo) {
        user.setFirstName(userToUpdateInfo.getFirstName());
        user.setLastName(userToUpdateInfo.getLastName());
        user.setEmail(userToUpdateInfo.getEmail());
        user.setPassword(userToUpdateInfo.getPassword());
        return user;
    }

    private User getUserFromDB(long id){
       return  userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with ID %s doesn't exist", id)));
    }
}

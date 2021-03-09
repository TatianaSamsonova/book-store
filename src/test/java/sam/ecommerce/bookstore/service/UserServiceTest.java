package sam.ecommerce.bookstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import sam.ecommerce.bookstore.exception.AlreadyExistException;
import sam.ecommerce.bookstore.model.User;
import sam.ecommerce.bookstore.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {
    private static final long USER_ID = 1;

    @Autowired
    private UserService userService;
    @MockBean
    private User user;
    @MockBean
    private List<User> users;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void shouldReturnListOfUsers_whenTheyExistInDB(){
        when(userRepository.findAll()).thenReturn(users);

        assertThat(userService.getAllUsers()).isEqualTo(users);
    }

    @Test
    public void shouldSaveUserInDB_whenUserIsNotNull(){
        userService.createUser(user);

        verify(userRepository).save(user);
    }

    @Test
    public void shouldThrowAlreadyExistException_whenUserIdExistsInDB(){
        when(userRepository.existsById(any())).thenReturn(true);

        assertThatThrownBy(() -> userService.createUser(user))
                .isInstanceOf(AlreadyExistException.class);
    }

    @Test
    public void shouldThrowNullPointerException_whenUserIsNull(){
        assertThatThrownBy(() -> userService.createUser(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldReturnDeletedUser_whenUserExistsInDB(){
        when(userRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        assertThat(userService.deleteUser(USER_ID)).isEqualTo(user);
    }

    @Test
    public void shouldDeleteUser_whenUserExistsInDB(){
        when(userRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        userService.deleteUser(USER_ID);
        verify(userRepository).deleteById(USER_ID);
    }

    @Test
    public void shouldThrowEntityNotFoundException_whenUserNotExistsInDB(){
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.deleteUser(USER_ID))
                .isInstanceOf(EntityNotFoundException.class);
    }

}

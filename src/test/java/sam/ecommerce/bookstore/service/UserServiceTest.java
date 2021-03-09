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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

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
}

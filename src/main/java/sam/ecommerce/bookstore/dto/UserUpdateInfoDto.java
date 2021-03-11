package sam.ecommerce.bookstore.dto;

import sam.ecommerce.bookstore.validation.email.ValidEmail;
import sam.ecommerce.bookstore.validation.password.ValidPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserUpdateInfoDto {
    @ValidEmail
    private String email;

    @NotEmpty
    @Size(min = 2, max = 20, message = "Please enter your first name between {min} and {max} characters")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20, message = "Please enter your last name between {min} and {max} characters")
    private String lastName;

    @ValidPassword
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

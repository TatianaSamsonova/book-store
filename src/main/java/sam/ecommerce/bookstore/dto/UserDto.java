package sam.ecommerce.bookstore.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class UserDto {
    private long id;
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Role cannot be null")
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

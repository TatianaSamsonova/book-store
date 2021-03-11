package sam.ecommerce.bookstore.dto;

import java.util.List;
import java.util.Map;

public class ErrorDto {
    private String role;
    private List<Map<String, String>> errors;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }

    public void setErrors(List<Map<String, String>> errors) {
        this.errors = errors;
    }
}

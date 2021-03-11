package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.dto.ErrorDto;

import java.util.Map;

public interface ErrorService {
    ErrorDto buildErrorDto(String role, Map<String, String> errorData);
}

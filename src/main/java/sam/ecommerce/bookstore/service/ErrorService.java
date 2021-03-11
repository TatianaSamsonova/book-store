package sam.ecommerce.bookstore.service;

import sam.ecommerce.bookstore.dto.ErrorDto;

import java.util.Map;

public interface ErrorService {
    ErrorDto buildErrorDto(String role, String name, String reason);
    Map<String, String> buildErrorItem(String fieldName, String message);
}

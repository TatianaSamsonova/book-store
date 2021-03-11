package sam.ecommerce.bookstore.service.impl;

import org.springframework.stereotype.Service;
import sam.ecommerce.bookstore.dto.ErrorDto;
import sam.ecommerce.bookstore.service.ErrorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultErrorService implements ErrorService {
    private static final String FIELD_NAME = "fieldName";
    private static final String MESSAGE = "message";

    @Override
    public ErrorDto buildErrorDto(String role, Map<String, String> errorData){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setRole(role);
        List<Map<String,String>> errorList = new ArrayList<>();

        errorData.forEach((fieldName, message) ->{
            errorList.add(buildErrorItem(fieldName, message));
        });

        errorDto.setErrors(errorList);

        return errorDto;
    }

    private Map<String, String> buildErrorItem(String fieldName, String message){
        Map<String, String> errorAttributes = new HashMap<>();

        errorAttributes.put(FIELD_NAME, fieldName);
        errorAttributes.put(MESSAGE, message);

        return errorAttributes;
    }
}

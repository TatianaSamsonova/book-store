package sam.ecommerce.bookstore.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sam.ecommerce.bookstore.dto.ErrorDto;
import sam.ecommerce.bookstore.service.ErrorService;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
public class BookStoreExceptionHandler {
    private static final String MOCK_ROLE = "User"; //TODO: fix after Spring Security adding
    private static final String DATA = "Data from DB";
    private static final String FIELD_NAME_NOT_INITIALIZED = "Field name not initialized";
    private static final String DEFAULT_ERROR_MESSAGE = "An unknown error has occurred";

    @Autowired
    private ErrorService errorService;

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleAlreadyExistException(AlreadyExistException ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE, Map.of(ex.getFieldName(),ex.getMessage()));

        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ImageUploadException.class)
    public ResponseEntity<ErrorDto> handleImageUploadException(ImageUploadException ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE, Map.of(ex.getFieldName(),ex.getMessage()));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorDto> handleInvalidDataException(InvalidDataException ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE, Map.of(ex.getFieldName(),ex.getMessage()));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE, Map.of(DATA, ex.getMessage()));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE, getErrorData(ex));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleAllExceptionMethod(Exception ex) {
        ErrorDto errorDto = getErrorDto(MOCK_ROLE,
                Map.of(FIELD_NAME_NOT_INITIALIZED, Optional.ofNullable(ex.getMessage()).orElse(DEFAULT_ERROR_MESSAGE)));

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, String> getErrorData(MethodArgumentNotValidException ex){
        Map<String, String> errorData = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError ->  errorData.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return errorData;
    }

    private ErrorDto getErrorDto(String role, Map<String, String> errorData){
        return errorService.buildErrorDto(role, errorData);
    }
}

package sam.ecommerce.bookstore.exception;

public class InvalidDataException extends DefaultBookStoreException{
    private static final long serialVersionUID = 1L;

    public InvalidDataException(String message, String fieldName) {
        super(message, fieldName);
    }
}

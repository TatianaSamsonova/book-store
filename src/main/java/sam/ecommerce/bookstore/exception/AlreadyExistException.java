package sam.ecommerce.bookstore.exception;

public class AlreadyExistException extends DefaultBookStoreException{
    private static final long serialVersionUID = 1L;

    public AlreadyExistException(String message, String fieldName) {
        super(message, fieldName);
    }
}

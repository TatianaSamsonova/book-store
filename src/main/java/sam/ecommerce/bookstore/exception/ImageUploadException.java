package sam.ecommerce.bookstore.exception;

public class ImageUploadException extends DefaultBookStoreException{
    private static final long serialVersionUID = 1L;

    public ImageUploadException(String message, String fieldName) {
        super(message, fieldName);
    }
}

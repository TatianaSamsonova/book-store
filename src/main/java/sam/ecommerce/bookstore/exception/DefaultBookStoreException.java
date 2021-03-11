package sam.ecommerce.bookstore.exception;

public class DefaultBookStoreException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String fieldName;

    public DefaultBookStoreException(final String message, final String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }
}

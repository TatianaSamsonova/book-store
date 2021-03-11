package sam.ecommerce.bookstore.model;

public enum Role {
    USER ("user"),
    ADMIN ("admin"),
    SUPER_ADMIN ("super_admin"),
    ANONYMOUS ("anonymous");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

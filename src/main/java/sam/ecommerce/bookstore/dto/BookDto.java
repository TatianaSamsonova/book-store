package sam.ecommerce.bookstore.dto;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class BookDto {
    private long id;
    @NotEmpty(message = "Book name cannot be empty")
    private String name;
    @NotEmpty(message = "Book author cannot be empty")
    private String author;
    private String price;
    private UUID imageCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public UUID getImageCode() {
        return imageCode;
    }

    public void setImageCode(UUID imageCode) {
        this.imageCode = imageCode;
    }
}

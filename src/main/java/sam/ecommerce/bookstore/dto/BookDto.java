package sam.ecommerce.bookstore.dto;

import javax.validation.constraints.NotEmpty;

public class BookDto {
    private long id;
    @NotEmpty(message = "Book name cannot be empty")
    private String name;
    @NotEmpty(message = "Book author cannot be empty")
    private String author;
    private String price;
    private byte[] picByte;

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

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}

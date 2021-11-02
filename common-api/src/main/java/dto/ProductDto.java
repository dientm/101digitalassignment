package dto;

public class ProductDto {
    private long id;
    private String name;
    private double price;

    public long getId() {
        return id;
    }

    public ProductDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        this.price = price;
        return this;
    }
}

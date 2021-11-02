package dto.ordering;

import java.util.List;

import dto.ProductDto;
import dto.ShopDto;
import dto.user.UserDto;

public class OrderDto {

    private long id;

    private UserDto user;

    private ShopDto shop;

    private String status;

    private List<ProductDto> items;

    public long getId() {
        return id;
    }

    public OrderDto setId(long id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public OrderDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public ShopDto getShop() {
        return shop;
    }

    public OrderDto setShop(ShopDto shop) {
        this.shop = shop;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<ProductDto> getItems() {
        return items;
    }

    public OrderDto setItems(List<ProductDto> items) {
        this.items = items;
        return this;
    }
}

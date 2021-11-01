package dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
    private long id;
    private long userId;
    private long shopId;
    private List<OrderItemDto> items;
}

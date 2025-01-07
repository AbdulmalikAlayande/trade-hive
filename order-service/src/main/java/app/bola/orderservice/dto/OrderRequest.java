package app.bola.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(
        Long orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}

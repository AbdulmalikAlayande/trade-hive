package app.bola.productservice.dto.response;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description,
                              String skuCode, BigDecimal price) {
}
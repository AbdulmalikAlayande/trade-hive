package app.bola.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockCheckResponse {

    private boolean isInStock;
    private String skuCode;
    private Integer requestedQuantity;
    private Integer availableQuantity;

}
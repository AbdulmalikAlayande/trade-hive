package app.bola.productservice.controller;

import app.bola.productservice.dto.request.ProductRequest;
import app.bola.productservice.dto.response.ProductResponse;
import app.bola.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecomapi/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        try {
            ProductResponse productResponse = productService.getProductById(id);
            return ResponseEntity.ok(productResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/sku/{skuCode}")
    public ResponseEntity<ProductResponse> getProductBySkuCode(@PathVariable String skuCode) {
        try {
            ProductResponse productResponse = productService.getProductBySkuCode(skuCode);
            return ResponseEntity.ok(productResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/exists/sku/{skuCode}")
    public boolean isProductExists(@PathVariable("skuCode") String skuCode) {
        return productService.isProductExists(skuCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}

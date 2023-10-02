package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room/hotelService/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("{id}")
    public Product getProductId(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.getProducts();
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    } 
}

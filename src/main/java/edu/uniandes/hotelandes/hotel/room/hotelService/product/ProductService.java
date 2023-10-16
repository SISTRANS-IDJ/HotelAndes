package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductDAO productDAO;

  @Autowired
  public ProductService(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  public void createProduct(Product product) {
    final var r = productDAO.insertProduct(product);
    if (r != 1) {
      throw new IllegalStateException("Product creation went wrong");
    }
  }

  public Product getProduct(Integer id) {
    return productDAO
        .selectProductById(id)
        .orElseThrow(
            () -> new NotFoundException(String.format("Product with id %s not found", id)));
  }

  public List<Product> getProducts() {
    return productDAO.selectProducts();
  }

  public Product updateProduct(Integer id, Product product) {
    final var products = productDAO.selectProductById(product.id());
    if (products.isPresent()) {
      final var r = productDAO.updateProduct(id, product);
      if (r != 1) {
        throw new IllegalStateException("Product update went wrong");
      }
      return product;
    } else {
      throw new IllegalStateException("Product doesn't exists");
    }
  }

  public void deleteProduct(Integer id) {
    final var products = productDAO.selectProductById(id);
    products.ifPresentOrElse(
        product -> {
          final var result = productDAO.deleteProduct(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete product");
          }
        },
        () -> {
          throw new NotFoundException(String.format("Product with id %s not found", id));
        });
  }
}

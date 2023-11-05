package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
  int insertProduct(Product product);

  Optional<Product> selectProductById(int id);

  List<Product> selectProducts();

  int updateProduct(int id, Product product);

  int deleteProduct(int id);
}

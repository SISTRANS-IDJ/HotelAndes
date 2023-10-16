package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDataAccessJDBC implements ProductDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ProductDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertProduct(Product product) {
    final var sql =
        "INSERT INTO hotel_product(name, description, cost, service_id) VALUES(?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql, product.name(), product.description(), product.cost(), product.serviceId());
  }

  @Override
  public Optional<Product> selectProductById(int id) {
    final var sql =
        "SELECT id, name, description, cost, service_id FROM hotel_product WHERE id = ?";
    final var products = jdbcTemplate.query(sql, new ProductRowMapper(), id);
    return products.stream().findFirst();
  }

  @Override
  public List<Product> selectProducts() {
    final var sql = "SELECT id, name, description, cost, service_id FROM hotel_product";
    return jdbcTemplate.query(sql, new ProductRowMapper());
  }

  @Override
  public int updateProduct(int id, Product product) {
    final var sql =
        "UPDATE hotel_product SET name = ?, description = ?, cost = ?, service_id = ? WHERE id = ?";
    return jdbcTemplate.update(
        sql, product.name(), product.description(), product.cost(), product.serviceId(), id);
  }

  @Override
  public int deleteProduct(int id) {
    final var sql = "DELETE FROM hotel_product WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}

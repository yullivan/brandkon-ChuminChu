package brandkon.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandId(Long brandId);
    @Query("SELECT DISTINCT p FROM Product p " +
            "JOIN p.brand b " +
            "JOIN BrandCategory bc ON bc.brand = b " +
            "WHERE bc.category.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

}

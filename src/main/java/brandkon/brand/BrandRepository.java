package brandkon.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    //List<Brand> findByCategorySlug(String slug);
}

package brandkon.brand;

import brandkon.category.Category;
import jakarta.persistence.*;

@Entity
public class BrandCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;
}

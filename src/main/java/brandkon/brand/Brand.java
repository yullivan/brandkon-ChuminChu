package brandkon.brand;

import brandkon.category.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private String guidelines;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<BrandCategory> brandCategories;

    public Brand() {
    }

    public Brand(String name, String imageUrl, String guidelines) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.guidelines = guidelines;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGuidelines() {
        return guidelines;
    }

}

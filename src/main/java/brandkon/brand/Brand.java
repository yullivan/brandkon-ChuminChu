package brandkon.brand;

import brandkon.category.Category;
import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private String guidelines;

    @ManyToOne //하나의 카테고리에 여러개의 브랜드가 들어감
    private Category category;

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

    public Category getCategory() {
        return category;
    }
}

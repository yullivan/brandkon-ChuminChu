package brandkon.product;

import brandkon.brand.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;

    @ManyToOne
    private Brand brand;

    public Product() {
    }

    public Product(String brandName, String productName, int price, String imageUrl, int expirationDays) {
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.expirationDays = expirationDays;
    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }
}

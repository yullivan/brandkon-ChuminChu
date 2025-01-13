package brandkon.product;

import brandkon.brand.Brand;
import brandkon.brand.BrandCategory;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    public Product() {
    }

    public Product(String productName, int price, String imageUrl, int expirationDays, Brand brand) {
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.expirationDays = expirationDays;
        this.brand = brand;
    }

    public Long getId() {
        return id;
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
    public int getExpirationDays() {
        return expirationDays;
    }

}

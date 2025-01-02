package brandkon.product;

import brandkon.brand.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> read(Long brandId) {
        if(brandId == null){
            return allProduct();
        }
        else return productOfBrandRead(brandId);
    }

    private List<ProductResponse> allProduct() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl()
        )).toList();
    }

    public List<ProductResponse> productOfBrandRead(Long brandId) {
        List<Product> byBrandId = productRepository.findByBrandId(brandId);
        return byBrandId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl())).toList();
    }

    public List<ProductResponse> popularRead(Long categoryId, Long brandId) {
        if (brandId == null) {
            return categoryPopular(categoryId);
        }
        if (categoryId == null) {
            return brandPopluar(brandId);
        }
        else throw new IllegalArgumentException("[ERROR]");
        }


    private List<ProductResponse> categoryPopular(Long categoryId) {
        List<Product> byBrandCategoryId = productRepository.findByBrandCategoryId(categoryId);
        return byBrandCategoryId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl()
        )).toList();
    }

    private List<ProductResponse> brandPopluar(Long brandId) {
        List<Product> byBrandId = productRepository.findByBrandId(brandId);
        return byBrandId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl()
        )).toList();
    }

    public detailProductResponse detailRead(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return new detailProductResponse(
                productId,
                product.getProductName(),
                product.getPrice(),
                product.getExpirationDays(),
                new Brand(
                        product.getBrand().getName(),
                        product.getImageUrl(),
                        product.getGuidelines())
        );
    }
}

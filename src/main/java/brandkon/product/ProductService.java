package brandkon.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getProducts(Long brandId) {
        if(brandId == null){
            return allProducts();
        }
        else return getProduct(brandId);
    }

    private List<ProductResponse> allProducts() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl()
        )).toList();
    }

    public List<ProductResponse> getProduct(Long brandId) {
        List<Product> byBrandId = productRepository.findByBrandId(brandId);
        return byBrandId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl())).toList();
    }

    public List<ProductResponse> readPopularProduct(Long categoryId, Long brandId) {
        if (brandId == null) {
            return readPopularCategory(categoryId);
        }
        if (categoryId == null) {
            return readPopularBrand(brandId);
        }
        else throw new IllegalArgumentException("[ERROR]");
        }


    private List<ProductResponse> readPopularCategory(Long categoryId) {
        List<Product> byBrandCategoryId = productRepository.findByCategoryId(categoryId);
        return byBrandCategoryId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrand().getName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl()
        )).toList();
    }

    private List<ProductResponse> readPopularBrand(Long brandId) {
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
        Product product = productRepository.findById(productId).orElseThrow(()->
                new NoSuchElementException("찾는 상품이 없습니다."));
        return new detailProductResponse(
                productId,
                product.getProductName(),
                product.getPrice(),
                product.getExpirationDays(),
                new detailProductResponse.Brand(
                        product.getBrand().getId(),
                        product.getBrand().getName(),
                        product.getBrand().getGuidelines())
        );
    }
}

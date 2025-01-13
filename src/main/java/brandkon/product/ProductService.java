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
        List<Product> byBrandCategoryId = productRepository.findByCategoryId(categoryId);
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

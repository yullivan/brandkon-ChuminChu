package brandkon.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> productOfBrand(Long brandId) {
        List<Product> byBrandId = productRepository.findByBrandId(brandId);
        return byBrandId.stream().map(product -> new ProductResponse(
                product.getId(),
                product.getBrandName(),
                product.getProductName(),
                product.getPrice(),
                product.getImageUrl())).toList();
    }
}

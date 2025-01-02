package brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> productOfbrandRead(@RequestParam(required = false) Long brandId){
        return productService.read(brandId);
    }

    @GetMapping("/products/{productId}")
    public detailProductResponse detailRead(@PathVariable Long productId){
        return productService.detailRead(productId);
    }

    @GetMapping("/products/popular")
    public List<ProductResponse> popularProduct(@RequestParam(required = false)Long categoryId, Long brandId){
        return productService.popularRead(categoryId, brandId);
    }


}

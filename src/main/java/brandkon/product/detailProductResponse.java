package brandkon.product;

import brandkon.brand.Brand;

import java.util.List;

public record detailProductResponse(
        Long productId,
        String productName,
        int price,
        int expirationDays,
        Brand brand

) {
}

package brandkon.product;

import brandkon.brand.Brand;

public record detailProductResponse(
        Long productId,
        String productName,
        int price,
        int expirationDays,
        Brand brand

) {
}

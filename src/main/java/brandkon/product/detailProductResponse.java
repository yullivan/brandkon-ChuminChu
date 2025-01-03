package brandkon.product;

import brandkon.brand.Brand;

public record detailProductResponse(
        Long productId,
        String productName,
        int price,
        int expirationDays,
        Brand brand

) {

    public record Brand(
            Long id,
            String name,
            String guidelines
    ){

    }
}

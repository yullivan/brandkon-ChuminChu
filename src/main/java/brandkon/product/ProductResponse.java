package brandkon.product;

public record ProductResponse(
        Long id,
        String brandName,
        String productName,
        int price,
        String imageUrl
) {
}

package brandkon.brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponse> read(String category) {
        List<Brand> categorySlug = brandRepository.findByCategorySlug(category);
        return categorySlug.stream().map(brand -> new BrandResponse(
                brand.getId(),
                brand.getName(),
                brand.getImageUrl()
        )).toList();
    }

    public BrandResponse oneBrandRead(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return new BrandResponse(brandId, brand.getName(), brand.getImageUrl());
    }
}

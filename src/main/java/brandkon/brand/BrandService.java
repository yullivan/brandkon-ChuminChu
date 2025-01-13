package brandkon.brand;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandCategoryRepository brandCategoryRepository;

    public BrandService(BrandRepository brandRepository, BrandCategoryRepository brandCategoryRepository) {
        this.brandRepository = brandRepository;
        this.brandCategoryRepository = brandCategoryRepository;
    }

    // N:M관계일때
    public List<BrandResponse> readBrands(String category) {
        List<BrandCategory> byCategorySlug = brandCategoryRepository.findByCategorySlug(category);
        return byCategorySlug.stream().map(brandCategory ->
                new BrandResponse(
                        brandCategory.getBrand().getId(),
                        brandCategory.getBrand().getName(),
                        brandCategory.getBrand().getImageUrl()
                )).toList();
    }

    /*
    * 1:N 관계일때
    public List<BrandResponse> read(String category) {
        List<Brand> categorySlug = brandRepository.findByCategorySlug(category);
        return categorySlug.stream().map(brand -> new BrandResponse(
                brand.getId(),
                brand.getName(),
                brand.getImageUrl()
        )).toList();
    }*/

    /* 1:n 관계
    public BrandResponse oneBrandRead(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return new BrandResponse(brandId, brand.getName(), brand.getImageUrl());
    }*/

    public BrandResponse readBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() ->
                new NoSuchElementException("찾는 브랜드가 없습니다."));
        return new BrandResponse(
                brandId,
                brand.getName(),
                brand.getImageUrl());
    }
}

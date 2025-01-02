package brandkon.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponse> readAll() {
        List<Category> allCategory = categoryRepository.findAll();
        return allCategory.stream().map(category -> new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getSlug(),
                category.getImageUrl()))
                .toList();
    }

    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category saveNewCategory = categoryRepository.save(
                new Category(
                        categoryRequest.name(),
                        categoryRequest.slug(),
                        categoryRequest.imageUrl()));
        return new CategoryResponse(
                saveNewCategory.getId(),
                saveNewCategory.getName(),
                saveNewCategory.getSlug(),
                saveNewCategory.getImageUrl());
    }
}

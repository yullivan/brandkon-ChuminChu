package brandkon.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryResponse> categoryRead(){
        return categoryService.readAll();
    }

    @PostMapping("/categories")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.create(categoryRequest);
    }
}

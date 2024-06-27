package Java_Project.WebsiteBanHang.Controller;

import Java_Project.WebsiteBanHang.Model.Category;
import Java_Project.WebsiteBanHang.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    // List all categories
    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/index"; // Ensure that you have a Thymeleaf template named 'index.html' under 'categories' directory
    }

    // Show form to add a new category
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/add-category"; // Ensure that you have a Thymeleaf template named 'add-category.html' under 'categories' directory
    }

    // Handle the submission of the add form
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/add-category"; // Redirect back to add-category form if there are errors
        }
        categoryService.addCategory(category);
        return "redirect:/categories"; // Redirect to the list of categories
    }

    // Show form to update an existing category
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id: " + id));
        model.addAttribute("category", category);
        return "categories/update-category"; // Ensure that you have a Thymeleaf template named 'update-category.html' under 'categories' directory
    }

    // Handle the submission of the update form
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("category") Category category,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "categories/update-category"; // Redirect back to update-category form if there are errors
        }
        category.setId(id); // Set the ID of the category to be updated
        categoryService.updateCategory(category);
        return "redirect:/categories"; // Redirect to the list of categories
    }

    // Delete an existing category
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id: " + id));
        categoryService.deleteCategoryById(id);
        return "redirect:/categories"; // Redirect to the list of categories
    }
}

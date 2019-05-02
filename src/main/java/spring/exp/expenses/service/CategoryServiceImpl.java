package spring.exp.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exp.expenses.entity.Category;
import spring.exp.expenses.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserService userService;

    @Override
    public Category getCategory(Integer categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Override
    public String addCategory(Category category) {
        categoryRepository.save(category);
        return "new category is added";
    }

    @Override
    public String updateCategory(Category category) {
        for(Category u: categoryRepository.findAll())
            if (u.getId().equals(category.getId())){
                u.setName(category.getName());
                u.setActive(category.isActive());
                u.setUser(category.getUser());
                categoryRepository.save(u);
                return "category is updated";
            }
        return "no category with such id exists to update";
    }

    @Override
    public String deleteCategory(Integer categoryId) {
        for(Category u: categoryRepository.findAll())
            if (u.getId().equals(categoryId)){
                categoryRepository.delete(u);
                return "category is removed";
            }
        return "no category with such id exists to remove";
    }

    @Override
    public List<Category> getCategoriesByUser(String login, String password) {
        List<Category> categoryList = new ArrayList<>();
        for(Category c : categoryRepository.findAll()){
            if(c.getUser().getLogin().equals(login)
            && c.getUser().getPassword().equals(password)) {
                categoryList.add(c);
            }
        }
        return categoryList;
    }
}

package fr.fms.api.trainings.service;

import fr.fms.api.trainings.dao.CategoryRepository;
import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        return categoryRepository.findAll();}

    public Category saveCategory(Category t) {
        return categoryRepository.save(t);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> readCategory(Long id) {

        return  categoryRepository.findById(id);
    }
}

package fr.fms.api.trainings.service;

import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getCategory();
    Category saveCategory(Category t);
    void deleteCategory(Long id);
    Optional<Category> readCategory(Long id);
}

package fr.fms.api.trainings.web;


import fr.fms.api.trainings.entities.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.fms.api.trainings.service.ImplCategoryService;
import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryController {
    @Autowired
   ImplCategoryService implCategoryService;

    @GetMapping("/category")
    public List<Category> allCategory(){
        return implCategoryService.getCategory();
    }
    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category t){
        return implCategoryService.saveCategory(t);
    }
    @DeleteMapping("/category/{id}")
    public  void deleteCategory(@PathVariable("id") Long id){
        implCategoryService.deleteCategory(id);
    }
    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return implCategoryService.readCategory (id)
                .orElseThrow(() -> new RecordNotFoundException("Id de Formation "+ id +" n'existe pas"));
    }
}

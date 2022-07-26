package fr.fms.api.trainings.dao;

import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

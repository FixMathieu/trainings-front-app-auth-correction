package fr.fms.api.trainings.dao;

import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

/*import org.springframework.data.rest.core.annotation.RepositoryRestResource;*/
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/*@CrossOrigin("*")
@RepositoryRestResource*/
public interface TrainingRepository extends JpaRepository<Training,Long> {
    List<Training> findByCategory(Long id);
/*    List<Training> findAll();


    Training findById(Training t);*/



}

package fr.fms.api.trainings.service;
import fr.fms.api.trainings.dao.CategoryRepository;
import fr.fms.api.trainings.dao.TrainingRepository;

import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService {
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }
    public List<Training> getTrainingsByCategory(Long id){
        Category category=categoryRepository.getById(id);
        return trainingRepository.findByCategory(id);
    }
    public Training saveTraining(Training t) {
        return trainingRepository.save(t);
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    public Optional<Training> readTraining(Long id) {

       return  trainingRepository.findById(id);
   }

    public Training postTraining(Training t) {
        return trainingRepository.save(t);
    }
}

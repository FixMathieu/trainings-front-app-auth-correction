package fr.fms.api.trainings.web;

import fr.fms.api.trainings.entities.Category;
import fr.fms.api.trainings.entities.Training;
import fr.fms.api.trainings.service.ImplCategoryService;
import fr.fms.api.trainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
/*@RequestMapping("/api")*/
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;


    @GetMapping("/trainings")
    public List<Training> allTrainings(){
        return implTrainingService.getTrainings();
    }

  @PostMapping("/trainings")
   public Training saveTraining(@RequestBody Training t){
        System.out.println(t);
       return implTrainingService.saveTraining(t);
    }

/*    @PostMapping("/trainings")
    public Training postTraining(@RequestBody Training t){return implTrainingService.postTraining(t);}*/

    @DeleteMapping("/trainings/{id}")
    public  void deleteTraining(@PathVariable("id") Long id){
        implTrainingService.deleteTraining(id);
    }

 /*  @GetMapping("/trainings/{id}")
   public ResponseEntity<Training> getTrainingById(@PathVariable("id")Long id){
       Optional<Training> training = implTrainingService.readTraining(id);
        if(training.isPresent()){
            return new ResponseEntity<>(training.get(), HttpStatus.OK);
        }
       return null;
    }*/
    @GetMapping("/trainings/{id}")
    public Training getTrainingById(@PathVariable("id") Long id){
        return implTrainingService.readTraining(id)
                .orElseThrow(() -> new RecordNotFoundException("Id de Formation "+ id +" n'existe pas"));
    }

}



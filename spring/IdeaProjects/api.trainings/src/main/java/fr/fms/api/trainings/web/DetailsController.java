package fr.fms.api.trainings.web;

import fr.fms.api.trainings.entities.Details;
import fr.fms.api.trainings.service.ImplDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DetailsController {
    @Autowired
    private ImplDetailsService implDetailsService;
    @GetMapping("/details")
    public List<Details> allDetails(){return implDetailsService.getDetails();}
    @PostMapping("/details")
    public Details saveDetails(@RequestBody Details details){
        return implDetailsService.saveDetails(details);
    }

    @DeleteMapping("/details/{id}")
    public void deleteDetails(@PathVariable("id")Long id){
        implDetailsService.deleteDetails(id);
    }

    @GetMapping("/details/{id}")
    public Details getDetailsById(@PathVariable("id") Long id) {
        return implDetailsService.readDetails(id)
                .orElseThrow(() -> new RecordNotFoundException(" " + id + "  n'existe pas"));
    }
}

package fr.fms.api.trainings.service;

import fr.fms.api.trainings.dao.DetailsRepository;
import fr.fms.api.trainings.entities.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplDetailsService implements IDetailsService{

    @Autowired
    private DetailsRepository detailsRepository;
    @Override
    public List<Details> getDetails() {
        return detailsRepository.findAll();
    }

    @Override
    public Details saveDetails(Details d) {
        return detailsRepository.save(d);
    }

    @Override
    public void deleteDetails(Long id) {
        detailsRepository.deleteById(id);
    }

    @Override
    public Optional<Details> readDetails(Long id) {
        return detailsRepository.findById(id);
    }
}

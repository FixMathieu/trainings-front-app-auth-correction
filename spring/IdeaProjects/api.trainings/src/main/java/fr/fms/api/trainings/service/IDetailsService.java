package fr.fms.api.trainings.service;

import fr.fms.api.trainings.entities.Details;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDetailsService {
    List<Details> getDetails();

    Details saveDetails(Details d);

    void deleteDetails(Long id);

    Optional<Details> readDetails(Long id);
}

package fr.fms.api.trainings.dao;

import fr.fms.api.trainings.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

}

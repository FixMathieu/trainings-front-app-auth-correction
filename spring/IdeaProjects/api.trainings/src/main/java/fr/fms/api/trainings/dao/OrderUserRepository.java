package fr.fms.api.trainings.dao;

import fr.fms.api.trainings.entities.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderUserRepository extends JpaRepository<OrderUser,Long> {
}

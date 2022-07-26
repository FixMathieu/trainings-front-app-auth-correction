package fr.fms.api.trainings.service;

import fr.fms.api.trainings.entities.OrderUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IOrderUserService {
    List<OrderUser> getOrderUser();
    OrderUser saveOrderUser(OrderUser t);
    void deleteOrderUser(Long id);
    Optional<OrderUser> readOrderUser(Long id);
}

package fr.fms.api.trainings.service;

import fr.fms.api.trainings.dao.OrderUserRepository;
import fr.fms.api.trainings.entities.OrderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplOrderUserService implements IOrderUserService{
    @Autowired
    private OrderUserRepository orderUserRepository;
    @Override
    public List<OrderUser> getOrderUser(){
        return orderUserRepository.findAll();
    }

    @Override
    public OrderUser saveOrderUser(OrderUser t) {
        return orderUserRepository.save(t);
    }

    @Override
    public void deleteOrderUser(Long id) {
orderUserRepository.deleteById(id);
    }

    @Override
    public Optional<OrderUser> readOrderUser(Long id) {
        return orderUserRepository.findById(id);
    }
}

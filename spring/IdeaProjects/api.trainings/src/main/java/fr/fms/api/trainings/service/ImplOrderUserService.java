package fr.fms.api.trainings.service;

import fr.fms.api.trainings.dao.CustomerRepository;
import fr.fms.api.trainings.dao.DetailsRepository;
import fr.fms.api.trainings.dao.OrderUserRepository;
import fr.fms.api.trainings.entities.Details;
import fr.fms.api.trainings.entities.OrderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplOrderUserService implements IOrderUserService{
    @Autowired
    private OrderUserRepository orderUserRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<OrderUser> getOrderUser(){
        return orderUserRepository.findAll();
    }

    @Override
    public OrderUser saveOrderUser(OrderUser orderUser) {

//      for (int i=0 ; i<orderUser.getDetails().size() ; i++) {
//        detailsRepository.save(orderUser.getDetails().);
//      }

      OrderUser orderToSave = orderUserRepository.save(new OrderUser());
      customerRepository.save(orderUser.getCustomer());

      for (Details details : orderUser.getDetails()){
        System.out.println(details);
        details.setOrderUser(orderToSave);
        detailsRepository.save(details);
      }
      orderUser.setId(orderToSave.getId());
      return orderUserRepository.save(orderUser);
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

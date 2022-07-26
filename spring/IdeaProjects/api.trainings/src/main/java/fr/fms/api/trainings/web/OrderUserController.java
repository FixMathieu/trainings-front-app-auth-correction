package fr.fms.api.trainings.web;

import fr.fms.api.trainings.entities.OrderUser;

import fr.fms.api.trainings.service.ImplOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderUserController {
    @Autowired
    private ImplOrderUserService implOrderUserService;

    @GetMapping("/orderUser")
    public List<OrderUser> allOrderUser(){return implOrderUserService.getOrderUser();}

    @PostMapping("/orderUser")
    public OrderUser saveOrderUser(@RequestBody OrderUser t){
        return implOrderUserService.saveOrderUser(t);
    }

    @DeleteMapping("/orderUser/{id}")
    public void deleteOrderUser(@PathVariable("id")Long id){
        implOrderUserService.deleteOrderUser(id);
    }

    @GetMapping("/orderUser/{id}")
    public OrderUser getOrderUserById(@PathVariable("id")Long id){
        return implOrderUserService.readOrderUser(id)
                .orElseThrow(()-> new RecordNotFoundException(" "+id+" n'existe pas"));
    }
}

package fr.fms.api.trainings;

import fr.fms.api.trainings.dao.*;
import fr.fms.api.trainings.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private TrainingRepository trainingRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderUserRepository orderUserRepository;

	@Autowired
	private DetailsRepository detailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category language = categoryRepository.save(new Category(null,"Langage de programmation",null));
		Category cms = categoryRepository.save(new Category(null,"CMS",null));
		Category framework = categoryRepository.save(new Category(null,"Framework",null));
		Training n1 = trainingRepository.save(new Training(null,"JAVA","Java Standard Edition 8 sur 5 Jours",3500.0,1,language));
		Training n2 =trainingRepository.save(new Training(null,"DotNet","DotNet & entityframework en 5 jours",2750.0,1,framework));
		Training n3 =trainingRepository.save(new Training(null,"PowerBi","Business Intelligence 5 jours",3000.0,1,language));
		Training n4 =trainingRepository.save(new Training(null,"NodeJs","Prise en main de NodeJs/Epress 2 jours",1400.0,1,cms));
		Training n5 =trainingRepository.save(new Training(null,"Php","Initiation au Dev/Web avec Php 4 jours",1300.00,1,language));

		Customer mathieu = customerRepository.save(new Customer(null,"mathieu","fix","0558010203","Dax","mathieu@gmail.com",null));
		OrderUser myOrder = orderUserRepository.save(new OrderUser(null,11950,mathieu,null));

		detailsRepository.save(new Details(null,1,n1,myOrder));
		detailsRepository.save(new Details(null,2,n2,myOrder));
		detailsRepository.save(new Details(null,2,n3,myOrder));
		detailsRepository.save(new Details(null,1,n4,myOrder));
	}
}

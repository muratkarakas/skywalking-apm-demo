package hello;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceBApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	private Logger logger  =  LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
	
	
	@GetMapping
	public  List<Customer> listAllCustomers(){
		return repository.findAll();
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Defne", "Karakas"));
		repository.save(new Customer("Deniz", "Karakas"));

		// fetch all customers
		logger.info("Customers found with findAll():");
		logger.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			logger.info("CUSTOMERS  {}  ",customer);
		}



	}

}

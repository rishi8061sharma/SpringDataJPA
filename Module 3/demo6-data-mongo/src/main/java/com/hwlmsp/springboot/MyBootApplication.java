package com.hwlmsp.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {

	@Autowired
	CustomerDAO custDAO;

	public void run(String... args) throws Exception {
		List<Customer> mylist=null; 
		System.out.println("custDAO.getClass() ::: "+custDAO.getClass());
		// 1.save() method - inserting 
		/*Customer cust1 = new Customer(106, "Sindhu", "sindhu@hwlmsp.com", 12345, "Blore", 7500); 
		custDAO.save(cust1); */
		// 2.insert() method - inserting 
		/*Customer cust2 = new Customer(108,"ppp", "ppp@jlc", 8888, "Blore",12500); 
		custDAO.insert(cust2);*/
		// 3.save() method - Updating 
		/*Optional<Customer> myOps1 = custDAO.findById("6160819352a03213330b01ec"); 
		if(myOps1.isPresent()) { 
		Customer cust = myOps1.get(); 
		cust.setCid(108); 
		cust.setCname("ddd"); 
		cust.setEmail("ddd@jlc"); 
		cust.setPhone(55555); 
		custDAO.save(cust); 
		} */
		//4. existsById 
		/*boolean b= custDAO.existsById("6160819352a03213330b01ec"); 
		System.out.println("Document Found : "+ b); */
		
		//5. findById 
		/*Optional<Customer> myOps2 = custDAO.findById("6160819352a03213330b01ec"); 
		myOps2.ifPresent(System.out::println); */
		
		//6. deleteById 
		//custDAO.deleteById("6160819352a03213330b01ec"); 
		
		//7. delete 
		/*Optional<Customer> myOps3 = custDAO.findById("6160015ff4d85bda8054c7e3"); 
		myOps3.ifPresent(mycust -> custDAO.delete(mycust));*/
		
		

		//8. count 
		//System.out.println("Total Customer : "+ custDAO.count()); 
		//9. findAll() 
		/*mylist = custDAO.findAll(); 
		mylist.stream().forEach(System.out::println);*/
		//10. findAll(Sort) 
				Sort nameSort = Sort.by(Order.asc("cname")); 
				mylist = custDAO.findAll(nameSort); 
				mylist.stream().forEach(System.out::println);

		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}

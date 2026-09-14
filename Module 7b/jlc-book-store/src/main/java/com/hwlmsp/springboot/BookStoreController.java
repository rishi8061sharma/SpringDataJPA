package com.hwlmsp.springboot;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;
/* 
 * @Author : Rishi Sharma
 * @company : HWL Advanced Technology Private Limited
 * */ 
public class BookStoreController {
	@Autowired 
	BookStoreService bookStoreService; 
	@GetMapping(value="/myorder/{orderId}/{userId}/{totalQty}/{totalCost}") 
	public String placeOrder(@PathVariable Integer orderId, @PathVariable String userId, 
			@PathVariable int totalQty,@PathVariable double totalCost) { 
		System.out.println("BookStoreController - placeOrder()"); 
		Order order=new Order(orderId, userId, totalQty, totalCost); 
		bookStoreService.placeOrder(order); 
		return "Your Order is placed successfully !!!"; 
	} 

}

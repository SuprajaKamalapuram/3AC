package com.spicy.kitchen.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spicy.kitchen.model.Menu;




@org.springframework.cloud.openfeign.FeignClient(name="menu-service",url = "http://localhost:8081")
public interface FeignClient {
   
	@LoadBalanced
	@RequestMapping(value = "/spicykitchen/menu",method = RequestMethod.POST)
	public Menu createMenu(Menu menu);
	@LoadBalanced
	@RequestMapping(value = "/spicykitchen/menu/{id}",method = RequestMethod.GET)
	public Menu getMenuById(@PathVariable String id);
}

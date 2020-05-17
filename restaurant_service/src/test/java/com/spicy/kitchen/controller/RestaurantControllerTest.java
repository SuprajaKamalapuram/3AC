package com.spicy.kitchen.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spicy.kitchen.model.Restaurant;
import com.spicy.kitchen.service.RestaurantService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class RestaurantControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RestaurantService service;
	
	@InjectMocks
	private RestaurantController controller;


   @Test
   public void testGetRestaurantById() throws Exception {
	   Mockito.when(service.getRestaurantById(101)).thenReturn(new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
                "India","Marathahalli","famous for biryani"));
	   
	   mockMvc.perform(get("/api/restaurant/101").accept(MediaType.APPLICATION_JSON)).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	   .andDo(print()).andExpect(jsonPath("$.id",is(101)));
   }
   
   @Test
   public void testCreateRestaurant() throws Exception {
	   Restaurant restaurant = new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
               "India","Marathahalli","famous for biryani");
	   Mockito.when(service.createRestaurant(restaurant)).thenReturn(restaurant);
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	   ObjectWriter ow =mapper.writer().withDefaultPrettyPrinter();
	   String requestJson=ow.writeValueAsString(restaurant);
	   System.out.println( requestJson);
	   mockMvc.perform(post("/api/restaurant/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestJson))
			   .andDo(print());
	   
		
   }
   
   @Test
   public void testDeleteRestaurant() throws Exception {
	   
       mockMvc.perform(delete("/api/restaurant/101"))
               .andReturn();
	   
	   
   }
   
   @Test
   public void testUpdateRestaurant() throws Exception {
	   Restaurant restaurant = new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
				  "India","Marathahalli","famous for biryani");
	   restaurant.setName("Paradise");
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	   ObjectWriter ow =mapper.writer().withDefaultPrettyPrinter();
	   String reqJson=ow.writeValueAsString(restaurant);
	    mockMvc.perform(put("/api/restaurant/101")
	      .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(reqJson)).andDo(print()).andReturn();
	   
	  
	   
   }
}

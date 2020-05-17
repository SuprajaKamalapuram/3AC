package com.spicy.kitchen.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spicy.kitchen.dao.RestaurantDao;
import com.spicy.kitchen.model.Restaurant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {
	
	@Autowired
	private RestaurantService service;
    
	@MockBean
	private RestaurantDao dao;

	@Test
	public void testCreateRestaurant() {
		Restaurant restaurant = new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
                "India","Marathahalli","famous for biryani");
		
        Mockito.when(dao.save(restaurant)).thenReturn(restaurant);

		assertThat(service.createRestaurant(restaurant)).isEqualTo(restaurant);

	}

	
	
	  @Test
	  public void testGetRestaurantById() { 
		  Restaurant restaurant = new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
	  "India","Marathahalli","famous for biryani");
	  
	  Mockito.when(dao.findById(101)).thenReturn(Optional.of(restaurant));
	  
	  service.getRestaurantById(101);
	 
	  }
  
	 
	@Test 
	public void testDeleteRestaurant() {
		
		Restaurant restaurant = new Restaurant(101,"Spicy Kitchen","Welcome to our restaurant","Banglore",
				                                    "India","Marathahalli","famous for biryani");
		dao.delete(restaurant);
		verify(dao,times(1)).delete(restaurant);
		
	}
}

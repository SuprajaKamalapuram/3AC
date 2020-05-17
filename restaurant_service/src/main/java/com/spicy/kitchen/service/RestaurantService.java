package com.spicy.kitchen.service;

import com.spicy.kitchen.model.Restaurant;


public interface RestaurantService {

	public Restaurant createRestaurant(Restaurant restaurant);
	public Restaurant getRestaurantById(Integer id);
	
	public void deleteRestaurant(Restaurant restaurant);
		
	
	
}
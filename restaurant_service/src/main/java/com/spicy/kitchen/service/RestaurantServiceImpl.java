package com.spicy.kitchen.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicy.kitchen.dao.RestaurantDao;
import com.spicy.kitchen.model.Restaurant;


@Service

public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	
	private RestaurantDao dao;
	
	

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return dao.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		dao.delete(restaurant);
	}




	





	
	
	

	
}

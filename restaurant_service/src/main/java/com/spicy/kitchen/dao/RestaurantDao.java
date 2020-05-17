package com.spicy.kitchen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spicy.kitchen.model.Restaurant;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant , Integer>,JpaRepository<Restaurant , Integer>  {

	
	
	
	
}

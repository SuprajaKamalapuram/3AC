package com.spicy.kitchen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id

	private final String id="3AC";
	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fk", referencedColumnName = "id")
	private List<Item> item;
	private transient String message;
	
	
	
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public String getId() {
		return id;
	}
	public Menu(List<Item> item) {
		super();
		this.item = item;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Menu(List<Item> item,String id) {
		super();
		this.item = item;
	}
	
	
	
	
	
	

}
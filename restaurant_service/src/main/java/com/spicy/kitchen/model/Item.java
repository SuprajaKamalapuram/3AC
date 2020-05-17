package com.spicy.kitchen.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer itemId;

	@Column(name = "name")
	private String itemName;

	@Column(name = "Description")
	private String itemDescription;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "type")
	private Type type;

	@OneToOne(targetEntity = Price.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "priceid_fk", referencedColumnName = "id")
	private Price price;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Item(Integer itemId, String itemName, String itemDescription, String ingredients, Type type, Price price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.ingredients = ingredients;
		this.type = type;
		this.price = price;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

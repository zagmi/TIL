package com.encore.spring.domain;

public class Item {
	private int itemId; //item_id
	private String name; //item_name
	private int price;
	private String description;
	private String url; //picture_url
	private int count;
	
	public Item(int itemNumber, String name, int price, String description, String url, int count) {
		super();
		this.itemId = itemNumber;
		this.name = name;
		this.price = price;
		this.description = description;
		this.url = url;
		this.count = count;
	}
	public Item(int itemNumber, String name, int price, String description, String url) {
		super();
		this.itemId = itemNumber;
		this.name = name;
		this.price = price;
		this.description = description;
		this.url = url;		
	}
	
	public Item() {	}	
	
	public Item(int itemId) {
		super();
		this.itemId = itemId;
	}	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", url=" + url + ", count=" + count + "]";
	}	
}

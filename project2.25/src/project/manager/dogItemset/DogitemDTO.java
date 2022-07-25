package project.manager.dogItemset;

import project.member.dogItem.DogShopProduct;

public class DogitemDTO {
	
	int num;
	String name;
	String price;
	
	
	
	
	
	
	public DogitemDTO(Integer num, String name, String price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	
	}
	
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	
	
	
	
	

}

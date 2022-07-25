package project.member.dogItem;

import javafx.scene.image.Image;

public class DogShopProduct {
	
	int num;
	String name;
	String price;
	String infor;
	String toyimg;
	public DogShopProduct() {
		
	}
	
	public DogShopProduct(Integer num ,String name) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.infor = infor;
	}
	
	public DogShopProduct(Integer num ,String name, String price , String infor ,String toyimg) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.infor = infor;
		this.toyimg = toyimg;
	}

	
	public String getPrice() {
		return price;
	}

	public String getInfor() {
		return infor;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getToyimg() {
		return toyimg;
	}

	public void setToyimg(String toyimg) {
		this.toyimg = toyimg;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}

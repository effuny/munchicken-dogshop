package project.manager;

public class Product {
	//2
	String id;
	String password;
	String number;
	
	public Product() {
		
	}
	
	public Product(String id, String password,String number) {
		super();
		this.id= id;
		this.password = password;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public String setId(String id) {
		return this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public String setNumber(String number) {
		return this.number = number;
	}
	
	

}

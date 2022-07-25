package project.manager.memberList.updatedeleteBoard;

public class UserProduct {
	String id;
	String password;
	String age;
	String gender;
	String number;
	String countryCode;
	
	// 개
	
	String dogName;
	String sex;
	String dogAge;
	String breed;
	
	public UserProduct() {
		
		
	}
	public UserProduct(String id,String password,String gender,String age,String countryCode, String number,
			String dogName,String sex,String dogAge,String breed) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.countryCode = countryCode;
		this.number = number;
		this.dogName = dogName;
		this.sex = sex;
		this.dogAge = dogAge;
		this.breed = breed;
		
	}
	
	
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDogAge() {
		return dogAge;
	}
	public void setDogAge(String dogAge) {
		this.dogAge = dogAge;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

	
	

}

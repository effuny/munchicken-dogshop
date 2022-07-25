package project.login;
/*
SQL> CREATE TABLE member (
  2  id varchar2(15),
  3  pw varchar2(15),
  4  gender varchar2(3),
  5  age varchar2(5),
  6  countrycode varchar2(18),
  7  phone varchar2(10),
  8  petname1 varchar2(10),
 9  petsex1 varchar2(3),
 10  petage1 varchar2(5),
 11  petbreed1 varchar2(18)
 12  );
 */

public class LoginDTO {
	private String id;
	private String pw;
	private String gender;
	private String age;
	private String countrycode;
	private String phone;
	private String petname1;
	private String petsex1;
	private String petage1;
	private String petbreed1;
	
	
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPetname1() {
		return petname1;
	}
	public void setPetname1(String petname1) {
		this.petname1 = petname1;
	}
	public String getPetsex1() {
		return petsex1;
	}
	public void setPetsex1(String petsex1) {
		this.petsex1 = petsex1;
	}
	public String getPetage1() {
		return petage1;
	}
	public void setPetage1(String petage1) {
		this.petage1 = petage1;
	}
	public String getPetbreed1() {
		return petbreed1;
	}
	public void setPetbreed1(String petbreed1) {
		this.petbreed1 = petbreed1;
	}
	
	
	

}

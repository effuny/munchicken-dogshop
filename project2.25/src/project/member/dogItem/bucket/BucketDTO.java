package project.member.dogItem.bucket;

public class BucketDTO {
	
	private String name;
	private String price;
	private String infor;
	private String id;
	
	public BucketDTO() { 
		
	}
	
	
	public BucketDTO(String name, String price, String infor) {
		super();
		this.name = name;
		this.price = price;
		this.infor = infor;
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
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}

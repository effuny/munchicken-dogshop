package project.member.messageBoard;

public class Review2 {
	
	String title;
	String id;
	String product;
	String content;
	String img;



	public Review2(String title, String id, String product, String content, String img) {
		super();
		this.title = title;
		this.id = id;
		this.product = product;
		this.content = content;
		this.img = img;
	}
	
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
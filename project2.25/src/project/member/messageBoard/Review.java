package project.member.messageBoard;

public class Review {

	String title;
	String id;
	String treatment;
	String content;
	
	
	
	

	public Review(String title, String id, String treatment, String content) {
		super();
		this.title = title;
		this.id = id;
		this.treatment = treatment;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}

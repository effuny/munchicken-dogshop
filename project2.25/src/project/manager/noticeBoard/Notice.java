package project.manager.noticeBoard;

public class Notice {

	String title;
	String noticedate;
	String content;

	
	
	public Notice(String title, String noticedate, String content) {
		super();
		this.title = title;
		this.noticedate = noticedate;
		this.content = content;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoticedate() {
		return noticedate;
	}

	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	
	
	
	
	
	
}


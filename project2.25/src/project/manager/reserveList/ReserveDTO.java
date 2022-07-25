package project.manager.reserveList;

public class ReserveDTO {
	
	String name;
	String service;
	String serviceDate;
	String serviceHour;
	String id;
	
	
	public ReserveDTO(String name, String service, String serviceDate, String serviceHour, String id) {
		super();
		this.name = name;
		this.service = service;
		this.serviceDate = serviceDate;
		this.serviceHour = serviceHour;
		this.id = id;
	}
	
	

	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getService() { 
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getServiceDate() {
		return serviceDate;
	}


	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}


	public String getServiceHour() {
		return serviceHour;
	}


	public void setServiceHour(String serviceHour) {
		this.serviceHour = serviceHour;
	}
	
	
	
	
}

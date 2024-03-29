package org.cap.bim.model;

public class PublisherDto 
{
	
	private int publisherId;
	private String name;
	private String city ;
	private String stateCode;
	
	
	public PublisherDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PublisherDto(int publisherId, String name, String city, String stateCode) {
		super();
		this.publisherId = publisherId;
		this.name = name;
		this.city = city;
		this.stateCode = stateCode;
	}


	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	


}

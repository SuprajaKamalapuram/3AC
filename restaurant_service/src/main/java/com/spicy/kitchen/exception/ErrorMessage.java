package com.spicy.kitchen.exception;

import java.time.LocalDateTime;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "error")
public class ErrorMessage 
{
   
 
    //General error message about nature of error
    private String message;
    private Integer status;
    private LocalDateTime ErrorTime;
    //Specific errors in API request processing
    private List<String> details;
    
    
    
    
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getErrorTime() {
		return ErrorTime;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		ErrorTime = errorTime;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public ErrorMessage(String message, Integer status, LocalDateTime errorTime, List<String> details) {
		super();
		this.message = message;
		this.status = status;
		ErrorTime = errorTime;
		this.details = details;
	}

	
	
 
    
}
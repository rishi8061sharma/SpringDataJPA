package com.hwlmsp.springboot;
import com.fasterxml.jackson.annotation.JsonFormat; 
import java.time.LocalDateTime; 


public class MyErrorMessage {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss") 
	private LocalDateTime mytimestamp; 
	
	private int mystatus;
	
	private String myerror;
	
	public MyErrorMessage() { 
	}

	public MyErrorMessage(LocalDateTime mytimestamp, int mystatus, String myerror) {
		super();
		this.mytimestamp = mytimestamp;
		this.mystatus = mystatus;
		this.myerror = myerror;
	}

	public LocalDateTime getMytimestamp() {
		return mytimestamp;
	}

	public void setMytimestamp(LocalDateTime mytimestamp) {
		this.mytimestamp = mytimestamp;
	}

	public int getMystatus() {
		return mystatus;
	}

	public void setMystatus(int mystatus) {
		this.mystatus = mystatus;
	}

	public String getMyerror() {
		return myerror;
	}

	public void setMyerror(String myerror) {
		this.myerror = myerror;
	}

	@Override
	public String toString() {
		return "MyErrorMessage [" + mytimestamp +","+ mystatus + "," + myerror + "]";
	}
	
	
	
}

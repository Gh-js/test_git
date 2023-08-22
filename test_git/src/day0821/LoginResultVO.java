package day0821;

import java.sql.Date;

public class LoginResultVO {
	private String name;
	private Date date;
	
	
	public LoginResultVO() {
		super();
	}
	public LoginResultVO(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	@Override
	public String toString() {
		return "LoginVO [name=" + name + ", date=" + date + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


}//class

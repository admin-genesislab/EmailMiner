package genesislab.app.model;

import java.sql.Date;

public class User 
{
	private int usrID;
	private String usrName;
	private String password;
	private Date joinedDate;
	private String usrEmail;
	private String usrAddress;
	private String membership;
	
	public int getUsrID() {
		return usrID;
	}
	public void setUsrID(int usrID) {
		this.usrID = usrID;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	public String getUsrAddress() {
		return usrAddress;
	}
	public void setUsrAddress(String usrAddress) {
		this.usrAddress = usrAddress;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
}

import java.io.Serializable;

public class Staff implements Serializable{
	private String userID;
	private String password;
	private String name;
	
	public Staff(String userID, String password, String name){
		this.userID=userID;
		this.password=password;
		this.name=name;
	}
	
	public boolean validateStaff(String userID, String password){
		if(this.userID==userID && this.password==password)
			return true;
		return false;
	}
	
	public String getUserID(){
		return this.userID;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}

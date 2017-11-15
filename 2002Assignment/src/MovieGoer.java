import java.util.ArrayList;
import java.io.Serializable;
public class MovieGoer implements Serializable {
	private String userName;
	private String password;
	private String name;
	private ArrayList<Ticket> transactionHistory;
	
	public MovieGoer(String username, String passwd, String name){
		this.userName=username;
		this.password= passwd;
		this.name = name;
	}
	
	public boolean validateMovieGoer(String userName, String password){
		if(this.userName==userName && this.password==password){
			return true;
		}
		return false;

	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList getTransactionHistory(){
		return this.transactionHistory;
	}
	
	public void newTransaction(Ticket ticket){
		this.transactionHistory.add(ticket);
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
}

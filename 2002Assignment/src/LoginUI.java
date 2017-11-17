import java.util.*;
import java.io.*;
public class LoginUI {
	 static LoginMgr lMgr = new LoginMgr();
	 static StaffUI sUI = new StaffUI();
	 static MovieGoerUI mUI = new MovieGoerUI();

public static void main(String[] args){
	 
	 System.out.println("Welcome!");
	 Scanner sc = new Scanner(System.in);

	 String username,passwd;

	 while(true){
		 System.out.println("enter 1 if you are user and 0 if you are admin");
		 int isUser = sc.nextInt();sc.nextLine();
		 if(isUser ==1){
			 System.out.println("Please enter you username");
			 username = sc.nextLine();
			 System.out.println("Please enter you password");
			 passwd = sc.nextLine();
			 MovieGoer m= null;
			 if((m=lMgr.validateMovieGoer(username, passwd)) !=null  )
				 m=mUI.displayMenu(m);
			 else {
				 System.out.println("Invalid user name or invalid password");
			 }
			 lMgr.writeOutMovieGoer(m);
		 }
		 else if(isUser==0){
			 System.out.println("Please enter you username");
			 username = sc.nextLine();
			 Staff s  = null;
			 System.out.println("Please enter you password");
			 passwd = sc.nextLine();
			 System.out.println("validating");

			 if((s=lMgr.validateStaff(username, passwd))!=null) sUI.DisplayMenu();
			 else {
				 System.out.println("Invalid user name or invalid password");
			 }
			 
		 }
		 else{
			 System.out.println("Invalid input, please input again");
		 }
	 }
	 
 }
//	public static void main(String ars[]){
//		try{
//			FileOutputStream fout = new FileOutputStream("Staff.ser");
//			ObjectOutputStream oOut= new ObjectOutputStream(fout);
//			ArrayList<Staff> staffList = new ArrayList<Staff>();
//			Staff admin = new Staff("admin","123456","admin");
//			staffList.add(admin);
//			oOut.writeObject(staffList);
//			oOut.close();
//			fout.close();
//			
//			
//
//			FileOutputStream fout = new FileOutputStream("MovieGoer.ser");
//			ObjectOutputStream oOut= new ObjectOutputStream(fout);
//			ArrayList<MovieGoer> movieGoerList = new ArrayList<MovieGoer>();
//			MovieGoer mouse = new MovieGoer("test","123456","Vivien Soon");
//			Staff admin = new Staff("admin","123456","admin");
//			movieGoerList.add(mouse);
//			oOut.writeObject(movieGoerList);
//			oOut.close();
//			fout.close();
			
//			FileOutputStream fout = new FileOutputStream("Movie.ser");
//			ObjectOutputStream oOut= new ObjectOutputStream(fout);
//			ArrayList<Movie> movieList = null;
//			MovieGoer mouse = new MovieGoer("test","123456","Vivien Soon");
//			Staff admin = new Staff("admin","123456","admin");
//			
//			oOut.writeObject(movieList);
//			oOut.close();
//			fout.close();
//
//		}
//		catch(FileNotFoundException e1){
//			System.out.println("File does not exist");
//		}
//		catch(IOException e){
//			System.out.println("some io error occured");
//			e.printStackTrace();
//		}
		
		//System.out.println("Succeed");
		
		
//	}
}

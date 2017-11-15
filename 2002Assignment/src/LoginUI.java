import java.util.*;
import java.io.*;
public class LoginUI {
//	public static void main(String[] args){
////		ArrayList<String> cast =null;
////		ArrayList<Review> reviews =null;
////		Movie m = new TwoD("a title",MovieStatus.Now_Showing,"this is synopsis","this is director",cast,reviews);
////		System.out.println(m.getDirector());
////		ArrayList<Movie> mList = new ArrayList<Movie>();
////		mList.add(m);
////		Movie m2 = mList.get(0);
////		System.out.println("haha");
////		Movie m1=new TwoD();
////		m1.setTitle("this is a title");
////		System.out.println(m1.getTitle());
////
////		System.out.println(m2.getDirector());
//		ArrayList<Movie> movieList=new ArrayList<Movie>();
//		try{
//			FileInputStream filein = new FileInputStream("Movie.ser");
//			ObjectInputStream obin = new ObjectInputStream(filein);
//			movieList = (ArrayList<Movie>)obin.readObject();
//			for(int i=0;i<movieList.size();i++){
//				movieList.get(i).printMovieInfo();
//			}
//			obin.close();filein.close();
//		}
//		catch(FileNotFoundException e1){
//			System.out.println("File does not exist");
//		}
//		catch(IOException e){
//			System.out.println("some io error occured");
//		}
//		catch (ClassNotFoundException e3){
//				System.out.println("somehow no such class");
//		}
//	}
	
public static void main(String[] args){
	 
	 System.out.println("Welcome!");
	 Scanner sc = new Scanner(System.in);

	 String username,passwd;
	 LoginMgr lMgr = new LoginMgr();StaffUI sUI = new StaffUI();
	 MovieGoerUI mUI = new MovieGoerUI();
	 while(true){
		 System.out.println("enter 1 if you are user and 0 if you are admin");
		 int isUser = sc.nextInt();sc.nextLine();
		 if(isUser ==1){
			 System.out.println("Please enter you username");
			 username = sc.nextLine();
			 System.out.println("Please enter you password");
			 passwd = sc.nextLine();
			 MovieGoer m= null;
			 if((m=lMgr.validateMovieGoer(username, passwd)) !=null  )mUI.displayMenu(m);
			 else {
				 System.out.println("Invalid user name or invalid password");
			 }
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

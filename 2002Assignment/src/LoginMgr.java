import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class LoginMgr {
	ArrayList<MovieGoer> movieGoerList = new ArrayList<MovieGoer>();
	int mIndex;
	public MovieGoer validateMovieGoer(String userId,String password){
//		ArrayList<MovieGoer> movieGoerList= new ArrayList<MovieGoer>();
		MovieGoer m;
		try{
			FileInputStream filein = new FileInputStream("MovieGoer.ser");
			ObjectInputStream oin=new ObjectInputStream(filein);
			this.movieGoerList = (ArrayList<MovieGoer>)oin.readObject();
			oin.close();filein.close();
			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e3){
				System.out.println("no such class");
		}
		Iterator<MovieGoer> i = this.movieGoerList.iterator();
		while(i.hasNext()){
			m=i.next();
			if(m.getUserName().equals(userId)&&m.getPassword().equals(password)){
				this.mIndex = this.movieGoerList.indexOf(m);
				return m;
			}
		}
		return null;
		
	}
	public Staff validateStaff(String userId,String password){
		ArrayList<Staff> staffList= new ArrayList<Staff>();
		Staff s;
		try{
			FileInputStream filein = new FileInputStream("Staff.ser");
			System.out.println("read");
			ObjectInputStream oin=new ObjectInputStream(filein);
			staffList= (ArrayList<Staff>)oin.readObject();
			oin.close();filein.close();
			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("no such class");
		}
		Iterator<Staff> i = staffList.iterator();
		while(i.hasNext()){
			s=i.next();
			if(s.getUserID().equals(userId)&&s.getPassword().equals(password))return s;
		}
		return null;
		
	}
	
	public void writeOutMovieGoer(MovieGoer m){
		this.movieGoerList.set(mIndex, m);
		try{
			FileOutputStream fileName= new FileOutputStream("MovieGoer.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileName);
			out.writeObject(this.movieGoerList);
			out.close();
			fileName.close();
			System.out.println("debuginginging");
		}catch(IOException i){
			i.printStackTrace();
			
			
		}
	}
	
}

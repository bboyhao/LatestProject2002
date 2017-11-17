import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BuildMovieGoer {
	public static void main(String[] args){
		ArrayList<MovieGoer> mgList=new ArrayList<MovieGoer>();
		MovieGoer mg = new MovieGoer("test","123456","Tony");
		mgList.add(mg);
		try{
			FileOutputStream fileout = new FileOutputStream("MovieGoer.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(mgList);
			out.close();
			fileout.close();
			System.out.println("MovieGoer.ser is created!");
		}catch (IOException i) {
	         i.printStackTrace();
	      }
	}
}

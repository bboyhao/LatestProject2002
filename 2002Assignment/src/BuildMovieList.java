import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BuildMovieList {
	public static void main(String[] args){
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("Movie.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(movieList);
	         out.close();
	         fileOut.close();
	         System.out.printf("Movie.ser is created");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
}

import java.io.Serializable;
import java.util.ArrayList;

public class ThreeD extends Movie{
	static double classRate = 2;
	
	public ThreeD(){};
	
	public ThreeD(String title,MovieStatus movieStatus,String synopsis,String director,ArrayList<String> casts, ArrayList<Review> reviews){
		this.title=title;
		this.movieStatus=movieStatus;
		this.synopsis=synopsis;
		this.director=director;
		this.casts=casts;
		this.reviews=reviews;
	}
	public static void setClassRate(double newClassRate){
		classRate = newClassRate;
	}
	
	public double getClassRate(){
		return ThreeD.classRate;
	}
	
	public void printMovieInfo(){
		System.out.println(this.title + " [3D]");
		System.out.println(this.movieStatus);
		System.out.println("Total sale: "+this.sale);
		System.out.println("Director: " + this.director);
		System.out.println("BBStatus: "+this.bbStatus);
		System.out.print("Casts: ");
		for (int i = 0; i < this.casts.size(); i++) {
			if (i != casts.size() - 1) System.out.print(casts.get(i) + ", ");
			else System.out.println(casts.get(i) + ".");
		}
		System.out.println("Synopsis:");
		System.out.println(this.synopsis);
		if(this.reviews!=null){
			System.out.println("Overall Rating: " + this.getOverallRating());
			System.out.println("Reviews:");
			for (int i = 0; i < this.reviews.size(); i++)
				reviews.get(i).printReview();//!!!!
		}
		else{
			System.out.println("Overall Rating: there is no rating now");
			System.out.println("There is no review available now");
		}
		System.out.println();
	}
	
}
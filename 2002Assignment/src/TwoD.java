import java.util.ArrayList;

public class TwoD extends Movie{
	static double classRate = 0;
	public TwoD(){};
	public TwoD(String title,MovieStatus movieStatus,String synopsis,String director,ArrayList<String> casts, ArrayList<Review> reviews){
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
		return TwoD.classRate;
	}
	
	public void printMovieInfo(){
		System.out.println(this.title + " [2D]");
		System.out.println(this.movieStatus);
		System.out.println("Total sale: "+this.sale);
		System.out.println("Director: " + this.director);
		System.out.print("Casts: ");
		for (int i = 0; i < this.casts.size(); i++) {
			if (i != casts.size() - 1) System.out.print(casts.get(i) + ", ");
			else System.out.println(casts.get(i) + ".");
		}
		System.out.println("Synopsis:");
		System.out.println(this.synopsis);
		if(this.reviews!=null){
			System.out.println("Overall Rating: " + this.getOverallRating());
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
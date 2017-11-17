import java.io.Serializable;

public class Review implements Serializable{
	private MovieGoer movieGoer;
	private String review;
	private int rating;
	
	public Review(){};
	
	public Review(MovieGoer movieGoer, String review, int rating){
		this.movieGoer=movieGoer;
		this.review=review;
		this.rating=rating;
	}
	
	public void printReview(){
		System.out.print(this.movieGoer.getName() + "\n" + " (" + rating + ")" + "\n" + review);
	}

	public double getRating() {
		return rating;
	}
}

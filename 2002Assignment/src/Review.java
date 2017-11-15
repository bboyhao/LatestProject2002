
public class Review {
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
		System.out.println("Review: "+review);
		System.out.println("Rating: "+rating);
	}

	public double getRating() {
		// TODO Auto-generated method stub
		return rating;
	}
}

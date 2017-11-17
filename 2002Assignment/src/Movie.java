import java.io.Serializable;
import java.util.ArrayList;

public abstract class Movie implements Serializable{
	protected String title;
	protected MovieStatus movieStatus = MovieStatus.Coming_Soon;
	protected String synopsis;
	protected String director;
	protected ArrayList<String> casts = new ArrayList<String>();
	protected ArrayList<Review> reviews = new ArrayList<Review>();
	protected double sale = 0;
	protected boolean bbStatus = false;
	protected static double bbRate = 2;
	protected static double baseRate = 5;
		
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	public MovieStatus getMovieStatus(){
		return this.movieStatus;
	}
	public void setMovieStatus(MovieStatus movieStatus){
		this.movieStatus = movieStatus;
	}
	
	public String getSynopsis(){
		return this.synopsis;
	}
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}
	
	public String getDirector(){
		return this.synopsis;
	}
	public void setDirector(String director){
		this.director = director;
	}
	
	public ArrayList<String> getCasts(){
		return this.casts;
	}
	public void setCasts(ArrayList<String> casts){
		this.casts=casts;
	}
	public void addCast(String cast){
		this.casts.add(cast);
	}
	
	public void replaceCasts(String sourceCast, String targetCast){
		for (int i = 0; i < this.casts.size(); i++)
			if (casts.get(i) == targetCast){
				casts.set(i,sourceCast);
				return;
			}
		
		System.out.println("The cast: " + targetCast + " is not on the list.");
	}
	public void removeCast(String cast){
		casts.remove(cast);
	}
	
	public ArrayList<Review> getReviews(){
		return this.reviews;
	}
	public void updateReviews(Review review){
		if (this.reviews== null) this.reviews = new ArrayList<Review>();
		this.reviews.add(review);
	}
	public double getOverallRating(){
		double overallRating=0;
		if (this.reviews == null||reviews.size()==0) 
			return 0;
		
		for (int i = 0; i < this.reviews.size(); i++)
			overallRating += reviews.get(i).getRating();//!!!!
		
		overallRating /= reviews.size();
		
		return overallRating;
	}

	public double getSale(){
		return this.sale;
	}
	public void updateSale(double newSale){
		this.sale += newSale;
	}
	
	public boolean getBBStatus(){
		return this.bbStatus;
	}
	public void setBBStatus(){
		this.bbStatus = !bbStatus;
	}
	
	
	public static void setBBRate(double newBBRate){
		bbRate = newBBRate;
	}
	
	
	public static void setBaseRate(double newBaseRate){
		baseRate = newBaseRate;
	}
	
	public abstract double getClassRate();
	

	
	

	public abstract void printMovieInfo();
}
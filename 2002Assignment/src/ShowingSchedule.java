import java.text.SimpleDateFormat;
import java.util.*;
public class ShowingSchedule {
	private SeatPlan seatPlan;
	private Movie movie;
	private Cineplex cineplex;
	private Cinema cinema;
	private Date date;
	
	public SeatPlan getSeatPlan(){
		return this.seatPlan;
	}
	public ShowingSchedule(Cinema cinema, Cineplex cineplex, Movie movie, SeatPlan seatPlan, Date d){
		this.cinema=cinema;
		this.cineplex=cineplex;
		this.movie=movie;
		this.seatPlan=seatPlan;
		this.date = d;
	}
	public Movie getMovie(){
		return this.movie;
	}
	
	public Cineplex getCineplex(){
		return this.cineplex;
	}
	public Cinema getCinema(){
		return this.cinema;
	}
	public Date getDate(){
		return this.date;
	}
	public boolean updateSeat(int r, int c){
		if(validateSeatAvailability(r,c)){
			seatPlan.updateSeatPlan(r, c);
			return true;
		}
		return false;
			
	}
	public boolean validateSeatAvailability(int row, int col){
		char [][] seat= seatPlan.getSeatPlan();
		if(row<seat.length && col<seat[0].length && seat[row][col]=='O')return true;
		else return false;
	}
	
	public void printScheduleInfo(){
		System.out.println("Movie name: " + movie.getTitle());
		System.out.println("Cineplex name: " + cineplex.getName());
		System.out.println("Cinema code: " + cinema.getCinemaCode());
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		System.out.println("Showing time: " +ft.format(date));
	}
}

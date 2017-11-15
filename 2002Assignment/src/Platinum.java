import java.io.Serializable;
import java.util.*;

public class Platinum implements Cinema,Serializable{
	private String cinemaCode;
	private SeatPlan seatPlan;
	static double cinemaRate = 2.0;
	private ArrayList<ShowingSchedule> showList;
	
	public Platinum (String cinemaCode, SeatPlan seatplan, ArrayList<ShowingSchedule> showList){
		this.setCinemaCode(cinemaCode) ;
		this.seatPlan=seatplan ;
		this.showList=showList;
	}
	public Platinum() {
		cinemaCode=null;
		seatPlan=null;
		showList=null;
	}
	
	public ArrayList<ShowingSchedule> getShowingList(){
		return showList;
	}
	public void setShowingList(ArrayList<ShowingSchedule> showList){
		this.showList=showList;
	}
	
	
	public static void setCinemaTypeRate(double newRate){
		cinemaRate = newRate;
	}
	
	public double getCinemaTypeRate(){
		return Platinum.cinemaRate;
	}
	
	public SeatPlan getSeatPlan(){
		return seatPlan;
	}
	public void setSeatPlan(SeatPlan seatPlan){
		this.seatPlan=seatPlan;
	}

	public String getCinemaCode() {
		return cinemaCode;
	}

	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
	}
	
	public String printCinemaType(){
		return "Class: Platinum";
	}
}

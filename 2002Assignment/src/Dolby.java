import java.io.Serializable;
import java.util.*;

public class Dolby implements Cinema,Serializable{
	private String cinemaCode;
	private SeatPlan seatPlan;
	static double cinemaRate =1.0;
	private ArrayList<ShowingSchedule> showList;
	public Dolby (String cinemaCode, SeatPlan seatplan, ArrayList<ShowingSchedule> showList){
		this.setCinemaCode(cinemaCode) ;
		this.seatPlan=seatplan ;
		this.showList=showList;
	}
	
	public Dolby() {
		cinemaCode=null;
		seatPlan=null;
		showList=null;
	}
	public ArrayList<ShowingSchedule> getShowingList(){
		return showList;
	}
	public void setShowingList(ArrayList<ShowingSchedule> showlist){
		this.showList=showList;
	}
	
	
	public static void setCinemaTypeRate(double newRate){
		cinemaRate = newRate;
	}
	
	public String printCinemaType(){
		return "Class: Dolby";
	}
	
	public double getCinemaTypeRate(){
		return Dolby.cinemaRate;
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

	
	



	
}

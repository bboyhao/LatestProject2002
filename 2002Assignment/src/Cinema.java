import java.util.*;
public interface Cinema{
	public String getCinemaCode();
	public ArrayList<ShowingSchedule> getShowingList();
	public SeatPlan getSeatPlan();
	public double getCinemaTypeRate();
	public String printCinemaType();
	public void setShowingList(ArrayList<ShowingSchedule> showList);
//	public void setCinemaTypeRate(double rate);
	public void setSeatPlan(SeatPlan seatPlan);
	public void setCinemaCode(String code);
	
}

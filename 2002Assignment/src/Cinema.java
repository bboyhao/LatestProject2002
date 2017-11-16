import java.util.*;
public interface Cinema {
	public String getCinemaCode();
	public ArrayList<ShowingSchedule> getShowingList();
	public SeatPlan getSeatPlan();
	public double getCinemaTypeRate();
	public String printCinemaType();
}

import java.io.Serializable;

public class Senior extends Ticket implements Serializable{
	public Senior(ShowingSchedule showingschedule, MovieGoer movieGoer, int col,int row) {
		super(showingschedule, movieGoer, col, row);
	}

	protected static double discount = -2;
}

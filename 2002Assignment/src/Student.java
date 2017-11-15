import java.io.Serializable;

public class Student extends Ticket implements Serializable{
	public Student(ShowingSchedule showingschedule, MovieGoer movieGoer, int col, int row) {
		super(showingschedule, movieGoer, col, row);
	}

	protected static double discount = -1;
}

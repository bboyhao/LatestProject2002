import java.io.Serializable;

public class Student extends Ticket implements Serializable{
	public Student(ShowingSchedule showingSchedule, MovieGoer movieGoer, int col, int row) {
		super(showingSchedule, movieGoer, col, row);
	}
	
    public double getDiscount(){
    	return Student.discount;
    }

	protected static double discount = -1;
}

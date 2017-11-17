import java.io.Serializable;

public class Senior extends Ticket implements Serializable{
	public Senior(ShowingSchedule showingSchedule, MovieGoer movieGoer, int col,int row) {
		super(showingSchedule, movieGoer, col, row);
	}
    public double getDiscount(){
    	return Senior.discount;
    }
	protected static double discount = -2;
}

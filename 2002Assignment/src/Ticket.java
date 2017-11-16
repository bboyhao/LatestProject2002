import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket implements Serializable{          
                protected String transactionID;
                protected ShowingSchedule showingSchedule;
                protected MovieGoer movieGoer;
                protected double price;
                protected static double discount = 0;
                protected int col;
                protected int row;
                
                public Ticket(ShowingSchedule showingschedule, MovieGoer movieGoer,int col, int row){
                                this.transactionID = setTransactionID();
                                this.showingSchedule = showingSchedule;
                                this.movieGoer = movieGoer;
                                this.discount = discount;
                                this.col = col;
                                this.row = row;
                }
                
                public String setTransactionID(){
                                String cinemaCode = showingSchedule.getCinema().getCinemaCode();
                                Date date = showingSchedule.getDate();
                SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmm");
                                return cinemaCode+ft.format(date);
                                
                }
                
                public String getTransactionID() {
                                return transactionID;
                }
                
                public ShowingSchedule getShowingSchedule() {
                                return showingSchedule;
                }
                
                public MovieGoer getMovieGoer() {
                                return movieGoer;
                }
                
                public static void setDiscount(double newDiscount) {
                                discount = newDiscount;
                }
                
                public void setPrice(double price) {
                                this.price = price;
                }
                
                public double getPrice() {
                                return this.price;
                }
                
                public void printTicketInfo() {
                                System.out.println("Transaction ID: " + transactionID);
                                this.showingSchedule.printScheduleInfo();
                                System.out.println("Buyer name: " + this.movieGoer.getName());
                                System.out.println("Price" + this.price);
                }
}

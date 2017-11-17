import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Calendar;

public class BookingMgr {
                                
                public boolean updateSeat(ShowingSchedule showingSchedule, int row, int col) {
                                if(showingSchedule.updateSeat(row, col)) {
                                                return true;
                                }
                                else {
                                                return false;
                                }
                }              
                
                public double calculatePrice (ShowingSchedule showingSchedule, Ticket ticket) { 
                                Date date = showingSchedule.getDate();
                                double price = Movie.baseRate;

                                double movieRate = showingSchedule.getMovie().getClassRate();

                                double bbRate = 0;

                                if (showingSchedule.getMovie().getBBStatus()) {
                                                bbRate = Movie.bbRate;
                                }

                                double cinemaRate = showingSchedule.getCinema().getCinemaTypeRate();

                                double ticketDiscount = ticket.getDiscount();
                                
                                double dateRate = 0;
                                if (isWeekend(date)|isHoliday(date)){
                                                dateRate = 2;
                                }
//                                System.out.println(ticketDiscount);


                                price += movieRate+bbRate+cinemaRate+ticketDiscount+dateRate;
                                return price;
                }
                
                public Ticket generateTicket(int choice, ShowingSchedule showingSchedule, MovieGoer movieGoer, int row, int col) {
                                switch(choice) {
                                
                                                case 1:	
                                                                {Ticket t1 = new Ticket(showingSchedule,movieGoer,row,col);
                                                                return t1;}
                                                case 2: 
                                                                {Ticket t2 = new Student(showingSchedule,movieGoer,row,col);
                                                                return t2;}
                                                case 3:
                                                                {Ticket t3 = new Senior(showingSchedule,movieGoer,row,col);
                                                                return t3;}
                                                case 4:
                                                                return null;
                                                default:
                                                                return null;
                                }
                }
                
                public boolean isWeekend (Date date){
                                if ((date.getDay() == 0)||(date.getDay() == 5)||(date.getDay() == 6)){
                                       return true;
                                }
                                else{
                                      return false;
                                }
                }
                
                public boolean isHoliday (Date date){
                                ArrayList<Date> holidayList;
                                try {
                                 FileInputStream fileIn = new FileInputStream("holiday.ser");
                                 ObjectInputStream in = new ObjectInputStream(fileIn);
                                 holidayList = (ArrayList<Date>) in.readObject();
                         in.close();            
                         fileIn.close();
                      } catch (IOException i) {
                         i.printStackTrace();
                         return false;
                      } catch (ClassNotFoundException c) {        
                                System.out.println("holiday file not found");
                         c.printStackTrace();
                         return false;
                      }
                                
                                for (Date day: holidayList){
                                                if (day.getYear()==date.getYear()&&day.getMonth()==date.getMonth()&&day.getDate()==date.getDate()){
                                                                return true;
                                                }
                                }
                                return false;
                }
                

                
                public void addTransaction (MovieGoer movieGoer, Ticket t) {
                                ArrayList<Ticket> transaction = movieGoer.getTransactionHistory();
                                if (transaction == null) {
                                	transaction = new ArrayList<Ticket>();
                                	
                                }
                                transaction.add(t);
                                
                                movieGoer.setTransaction(transaction);
                }
                
                public void writeInCineplex(ArrayList<Cineplex> cList){
                    try {
                                    String path = "cineplexList.ser";
                                    FileOutputStream fileOut = new FileOutputStream(path);
                                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                                    out.writeObject(cList);
                                    out.close();
                                    fileOut.close();
                                    System.out.printf("Serialized data is saved in" + path +"\n");
                    } catch (IOException i) {
                    	i.printStackTrace();
                    }
    }
    
}

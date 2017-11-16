import java.util.ArrayList;
import java.io.*;
import java.util.*;
 
public class MovieGoerUI {
   MovieMgr movieMgr = new MovieMgr();
   BookingMgr bookingMgr = new BookingMgr();
   CineplexMgr cineplexMgr = new CineplexMgr();
   MovieGoer movieGoer;
   ArrayList<ShowingSchedule> showingList;
   ArrayList<Movie> mList;
   Movie movieChoice;
   ArrayList<Cineplex> cList;
   Cineplex cineplexChoice;
   ArrayList<ShowingSchedule> sList;
   ShowingSchedule scheduleChoice;
   int rowChoice;
   int colChoice;
   //ticket
  
   public MovieGoerUI(){};
   
   public void displayMenu(MovieGoer mGoer){
                   int userChoice;movieGoer = mGoer;
                   
      do {
         System.out.println("===============================================");
         System.out.println("Dear " + this.movieGoer.getName() + " :)");
         System.out.println("==========Welcome to NTUitive Village==========");
         System.out.println("1. Find a movie.");
         System.out.println("2. Show all Now-Showing.");
         System.out.println("3. Show all Coming-Soon.");
         System.out.println("4. Show all Cineplex.");
         System.out.println("5. Show top 5 movies by Sale.");
         System.out.println("6. Show top 5 movies by Rating.");
         System.out.println("7. Enter review.");
         System.out.println("8. View transaction history");
         System.out.println("9. Log out.");
         System.out.println("Please enter your choice (1-9):");
         Scanner sc = new Scanner(System.in);
         userChoice = sc.nextInt();
        
         switch (userChoice) {
            case 1: findMovie(); break;
            case 2: listNowShowing(); break;
            case 3: listComingSoon(); break;
            case 4: listCineplex(); break;
            case 5: listTopSale(); break;
            case 6: listTopRating(); break;
            case 7: createReview(); break;
            case 8: printTransaction(movieGoer); break;
            case 9:
               System.out.println("Bye bye " + movieGoer.getName() + ", see you soon!");
               break;
            default:
               System.out.println("Sorry I don't understand. Please check your choice.");
               break;
         }
      } while (userChoice != 9);
   }
  
   public void findMovie(){
      Scanner sc = new Scanner(System.in);
      System.out.println("======================");
      System.out.println("Enter the movie name:");
      String movieTitle = sc.next();
     
      this.mList = this.movieMgr.findMovie(movieTitle);
      printMovie();
      chooseMovie();
      bookMovie1();
   }
   public void listNowShowing(){
      Scanner sc = new Scanner(System.in);
      this.mList = this.movieMgr.findNowShowing();
      do{
         System.out.println("==========Now Showing==========");
         printMovie();
         System.out.println("===============================");
         System.out.println("1. Choose movie:");
         System.out.println("2. Go back to Main Menu.");
         System.out.println("Please enter your choice (1-2):");
         int userChoice = sc.nextInt();
         switch(userChoice){
            case 1:
               chooseMovie();
               bookMovie();
               return;
            case 2:
               this.movieChoice = null;
               return;
            default:
               System.out.println("Sorry I don't understand. Please check your choice.");
               break;
         }
      }while(true);
   }
   public void listComingSoon(){
      Scanner sc = new Scanner(System.in);
      System.out.println("======================================");
      this.mList = this.movieMgr.findComingSoon();
      printMovie();
      System.out.println("Press any key to go back to Main Menu.");
      String userChoice = sc.nextLine();
      return;
   }
   public void listCineplex(){
      Scanner sc = new Scanner(System.in);
      this.cList = this.cineplexMgr.findAllCineplex();
      do{
         System.out.println("=============List of Cineplex==============");
         printCineplex();
         System.out.println("1. Choose cineplex.");
         System.out.println("2. Go back to Main Menu.");
         System.out.println("Please enter your choice (1-2):");
         int userChoice = sc.nextInt();
         switch(userChoice){
            case(1):
               chooseCineplex();
               this.mList = this.cineplexMgr.findAllMovie();
               chooseMovie();
               bookMovie();
               return;
            case(2):
               this.cineplexChoice = null;
               return;
            default:
               System.out.println("Sorry I don't understand. Please check your choice.");
               break;
         }
      } while(true);
   }
   public void createReview(){
      Scanner sc = new Scanner(System.in);
      System.out.println("==============Movie Review==============");
      System.out.println("Enter the movie title:");
      String mTitle = sc.next();
      this.mList = this.movieMgr.findMovie(mTitle);
      printMovie();
      chooseMovie();
      System.out.println("Please enter your review for "+this.movieChoice.getTitle()+" below:");
      String review = sc.nextLine();
      System.out.println("Please enter your rating for "+this.movieChoice.getTitle()+"below"
      		+ "\n(please enter an integer between 1 and 5 inclusive"
      		+ " and 1 for the worst and 5 for the best):");
      int rating=sc.nextInt();
      while(rating<1||rating>5){
    	  System.out.println("The rating must be an integer from 1 to 5 inclusive\nPlease enter another rating");
    	  rating=sc.nextInt();
      }
      
      this.movieMgr.createReview(this.movieGoer, this.movieChoice,review,rating);
   }
   public void listTopSale(){
      this.mList = this.movieMgr.findTopSale();
      printMovie();
      chooseMovie();
      bookMovie1();
   }
   private void listTopRating(){
      this.mList = this.movieMgr.findTopRating();
      printMovie();
      chooseMovie();
      bookMovie1();
   }
   private void printMovie(){
	   int index;
      for (int i = 0 ; i < this.mList.size() ; i++) {
         Movie m = mList.get(i);
         index = i+1;
         System.out.print( index + ". ");
         m.printMovieInfo();
      }
   }
   private void chooseMovie(){
      Scanner sc = new Scanner(System.in);
      try{
         int index;
         System.out.println("Enter the index of movie: ");
         index = sc.nextInt();
         this.movieChoice = this.mList.get(index-1);
         return;
      }
      catch(Exception e) {
         System.out.println("Exception >> " + e.getMessage());
      }
   }
   private void printCineplex(){
	   int index;
      for (int i = 0 ; i < this.cList.size() ; i++) {
         Cineplex c = cList.get(i);
         index = i +1;
         System.out.print(index + ". ");
         c.printCineplexInfo();
      }
   }
   private void chooseCineplex(){
      Scanner sc = new Scanner(System.in);
      try{
         int index;
         System.out.println("Enter the index of cineplex: ");
         index = sc.nextInt();
         this.cineplexChoice = cList.get(index-1);
         return;
      }
      catch(Exception e){
         System.out.println("Exception >> " + e.getMessage());
      }
   }
   private void printSchedule(){
	  int index;
      for (int i = 0 ; i < this.sList.size() ; i++) {
         ShowingSchedule s = sList.get(i);
         index = i + 1;
         System.out.print(index + ". ");
         s.printScheduleInfo();
      }
   }
   private boolean chooseSchedule(){
                   Scanner sc = new Scanner(System.in);
      try{
         int index;
         System.out.println("Enter the index of show time schedule, or enter 0 to return to main menu: ");
         index = sc.nextInt();
         if (index != 0) {
                this.scheduleChoice = sList.get(index-1);
                return true;
        }
      }
      catch(Exception e){
         System.out.println("Exception >> " + e.getMessage());
      }
      return false;
   }
  
   private boolean chooseSeat(){
      Scanner sc = new Scanner(System.in);
      int r, c, userChoice = 1;
      boolean success = true;
      do{
         if (success == false) {
            System.out.println("Seat taken :(");
            System.out.println("1. Rechoose seat.");
            System.out.println("2. Back to previous Section.");
            System.out.println("Please enter your choice (1-2): ");
         }
         switch(userChoice){
            case 1:
               System.out.println("Enter the row and column (e.g. for row 4 column 10, enter 4 10)");
               r = sc.nextInt();
               c = sc.nextInt();
               rowChoice = r;
               colChoice = c;
               success = this.bookingMgr.updateSeat(this.scheduleChoice, r, c);
               break;
            case 2:
               this.scheduleChoice = null;
               return false;
            default:
               System.out.println("Sorry I don't understand. Please check your choice.");
               break;
         }
 
      } while(success == false);
      return true;
   }

   private void bookMovie1(){
      //start the book with only movie information
      boolean cond = true;
      Scanner sc = new Scanner(System.in);

      do{
         System.out.println("1. Book this movie.");
         System.out.println("2. Go back to Main Menu.");
         System.out.println("Please enter your choice (1-2):");
         int userChoice = sc.nextInt();
         switch(userChoice){
            case 1:
               bookMovie();
              return;
            case 2:
               this.movieChoice = null;
               return;
            default:
               System.out.println("Sorry I don't understand. Please check your choice.");
               break;
         }
      }while(true);
   }
   private void bookMovie(){
      try{
        
         if (cineplexChoice != null)
            this.sList = this.cineplexMgr.findShowingSchedule(movieChoice, cineplexChoice);
         else
            this.sList = this.cineplexMgr.findShowingSchedule(movieChoice);//need new overload in cineplexMgr. Print out all available schedule from all cineplex
         System.out.println("=====List of Show Time for " + movieChoice.getTitle() + "===============");
         printSchedule();
         if(chooseSchedule()==false) {
                return;
                      
         }
         this.scheduleChoice.getSeatPlan().printSeatPlan();
         if (chooseSeat()==false) {
                return;
         }
         
         Scanner sc = new Scanner(System.in);
         System.out.println("=====Choice Ticket Type======");
         System.out.println("Please choose the type of ticket you want to buy:");
         System.out.println("1. Normal Ticket");
         System.out.println("2. Student Ticket");
         System.out.println("3. Senior Ticket");
         System.out.println("4. return to main menu");
         
         int ticketChoice;
         do {
                System.out.print("Please enter your choice (1-4):");
                ticketChoice = sc.nextInt();
         }while(ticketChoice != (1|2|3|4));
         
         
         Ticket t = bookingMgr.generateTicket(ticketChoice, scheduleChoice, movieGoer, rowChoice, colChoice);
         if (t !=  null) {
         double price = bookingMgr.calculatePrice(scheduleChoice, t);
         t.setPrice(price);
         displayPaymentMsg(t);
         MovieMgr mMgr = new MovieMgr();
         this.mList = mMgr.readInMovie("Movie.ser");
         boolean is2d = t.getShowingSchedule().getMovie() instanceof TwoD;
         for(int i = 0;i<mList.size();i++){
        	 Movie m = mList.get(i);
        	 if(m.getTitle().equals(t.getShowingSchedule().getMovie().getTitle())){
        		 if(m instanceof TwoD&&is2d==true){
        			 m.updateSale(price);
        		 }
        		 else if(m instanceof ThreeD&&is2d==false){
        			 m.updateSale(price);
        		 }
        	 }
         }
         bookingMgr.addTransaction(movieGoer, t);
         }
         else return;
      }
      catch(Exception e){
         System.out.println("Exception >> " + e.getMessage());
      }
   }
   
   private void displayPaymentMsg(Ticket t){
                      System.out.println("Payment Successful!");
                      System.out.println("=====Ticket Infomation=====");
                      t.printTicketInfo();
                      System.out.println("===========================");
                   }
   
   private void printTransaction(MovieGoer movieGoer) {
                   ArrayList<Ticket> transaction = bookingMgr.readInTransaction(movieGoer);
                   
                   System.out.println("========Transaction History===========");
                   for (Ticket t: transaction) {
                                   t.printTicketInfo();
                                   System.out.println();
                   }
                   Scanner sc = new Scanner(System.in);
                   
                   System.out.println("======================================");
                   System.out.println("Press any key to go back to Main Menu.");
                   String userChoice = sc.next();
                
                   return;
   }
//   public static void main(String[] args) {
//     MovieGoerUI mUI = new MovieGoerUI();
//      if (movieGoer != null)
//         mUI.displayMenu(m);
//   }
}
 
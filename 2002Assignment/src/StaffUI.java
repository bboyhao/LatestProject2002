import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StaffUI {
	   MovieMgr movieMgr = new MovieMgr();
	   CineplexMgr cineplexMgr = new CineplexMgr();
	
	public void DisplayMenu(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Add holiday");
			System.out.println("2.Remove holiday");
			System.out.println("3.Change ticket price setting");
			System.out.println("4.Enter a forthcoming movie (Default Status: Coming_Soon)");
			System.out.println("5.Update details of a movie");
			System.out.println("6.Update showing status of a movie");
			System.out.println("7.List the top 5 movies by ticket sales");
			System.out.println("8.List the top 5 movies by overall ratings");
			System.out.println("9.Enter another showing schedule");
			System.out.println("10.Exit");
			
			int instruction  = sc.nextInt();
			sc.nextLine();
			switch(instruction){
				case 1: this.chooseDateWithNoTime(); break;
				case 2: this.removeDate(); break;
				case 3: this.changeBasePrice(); break;
				case 4: this.addNewMovie(); break;
				case 5: this.updateMovieDetail(); break;
				case 6: this.updateMovieStatus(); break;
				case 7: this.listTopSale();break;
				case 8: this.listTopRating(); break;
				case 9: this.addShowing();break;
				case 10: return;
				default: System.out.println("Invalid, input again");

			}
		}
	}
	
	public void listTopSale(){
		ArrayList<Movie> mList= new ArrayList<Movie>();
		Movie m; 
		mList = movieMgr.findTopSale();
		Iterator<Movie> ite = mList.iterator();
		System.out.println("=========================================================");
		System.out.println("These are the top 5 Movies with highest sale");
		int cnt = 1;
		while(ite.hasNext()){
			m=ite.next();
			System.out.println(" "+cnt + ". "+m.getTitle()+" with sales "+m.getSale() );
			cnt++;
		}
	}
	
	public void listTopRating(){
		ArrayList<Movie> mList= new ArrayList<Movie>();
		Movie m;
		mList = movieMgr.findTopRating();
		Iterator<Movie> ite = mList.iterator();
		System.out.println("=========================================================");
		System.out.println("These are the top 5 Movies with highest Rating");
		int cnt = 1;
		while(ite.hasNext()){
			m=ite.next();
			System.out.println(" "+cnt + ". "+m.getTitle()+" with Ratings "+m.getSale() );
			cnt++;
		}
		
	}
	public void addNewMovie(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("Please enter the title of the movie");
		String movieTitle=sc.nextLine();
		System.out.println("Please enter the synopsis of the movie");
		String synopsis = sc.nextLine();
		System.out.println("Please enter the director of the movie");
		String director = sc.nextLine();
		System.out.println("Please enter the casts of the movie one by one, enter # to end");
		ArrayList<String> casts= new ArrayList<String>();
		String tmpCast=sc.nextLine();
		while(!tmpCast.equals("#")){
			casts.add(tmpCast);
			tmpCast=sc.nextLine();
		}

		char is2D,is3D;
		
		while(true){
			System.out.println("Is 2D available? [Y/N]");
			is2D = sc.nextLine().charAt(0);
			if( is2D=='Y'||is2D=='y'){
				Movie m = new TwoD();
				m.setTitle(movieTitle);
				m.setDirector(director);
				m.setSynopsis(synopsis);
				m.setMovieStatus(MovieStatus.Coming_Soon);
				m.setCasts(casts);
				cineplexMgr.addNewMovie(m);
				break;
			}
			else if(is2D=='N'||is2D=='n')break;
			else System.out.println("Answer Y or N only");
		}
		while(true){
			System.out.println("Is 3D availale? [Y/N]");
			is3D = sc.nextLine().charAt(0);
			if( is3D=='Y'||is3D=='y'){
				Movie m = new ThreeD();
				m.setCasts(casts);
				m.setTitle(movieTitle);
				m.setDirector(director);
				m.setSynopsis(synopsis);
				m.setMovieStatus(MovieStatus.Coming_Soon);
				cineplexMgr.addNewMovie(m);
				break;
			}
			else if(is3D=='N'||is3D=='n')break;
			else System.out.println("Answer Y or N only");
		}
	}
	
	public void updateMovieStatus(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("Please enter the title of the movie");
		String movieTitle = sc.nextLine();
		System.out.println("Please enter the new status of the movie");
		System.out.println("1.Coming_soon");
		System.out.println("2.Now_Showing");
		System.out.println("3.End_of_showing");
		
		int newStatus = sc.nextInt();sc.nextLine();
		MovieStatus status;
		switch(newStatus){
		case 1: status = MovieStatus.Coming_Soon;break;
		case 2: status = MovieStatus.Now_Showing;break;
		case 3: status = MovieStatus.End_Of_Showing;break;
		default: System.out.println("No such status. Exiting");return;
		}
		
		ArrayList<Movie> mList= new ArrayList<Movie>();

		mList= cineplexMgr.findAllMovie();
		Iterator<Movie> ite = mList.iterator();
		boolean found = false;
		for(Movie m : mList){
			if(m.getTitle().equals(movieTitle)==true){
				m.setMovieStatus(status);found = true;
			}
		}

		if(found)cineplexMgr.updateMovie(mList);
		else System.out.println("not found");
		
	}
	
	public void updateMovieDetail(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("Please enter the title of the movie you want to update");
		String title = sc.nextLine();
		int instruction;
		Movie movie;
		ArrayList<Movie> mList= new ArrayList<Movie>();
		ArrayList<Movie> newMList = new ArrayList<Movie>();

		mList= cineplexMgr.findAllMovie();
		Iterator<Movie> ite = mList.iterator();
		boolean found = false;
		while(ite.hasNext()){
			movie = ite.next();
			if(movie.getTitle().equals(title)==true){
				found  = true;
				newMList.add(movie);
			}
		}
		if(found){
			while(true){
				System.out.println("=========================================================");
				System.out.println("Please choose what fields of the movie you want to update");
				System.out.println("1.Movie title");
				System.out.println("2.Movie synopsis");
				System.out.println("3.Movie director");
				System.out.println("4.Movie casts");
				System.out.println("5.Finish");
				instruction = sc.nextInt();
				sc.nextLine();
				switch(instruction){
				case 1: {
					System.out.println("Please enter a new title");
					String newTitle = sc.nextLine();
					for(int i = 0;i<newMList.size();i++){
						movie = newMList.get(i);
						movie.setTitle(newTitle);
						}
					break;
				}
				case 2:{
					System.out.println("Please enter a new synopsis");
					String newSynopsis = sc.nextLine();
					for(int i = 0;i<newMList.size();i++){
						movie = newMList.get(i);
						movie.setSynopsis(newSynopsis);
						}
					break;
				}
				case 3:{
					System.out.println("Please enter a new director name");
					String newDirector = sc.nextLine();
					for(int i = 0;i<newMList.size();i++){
						movie = newMList.get(i);
						movie.setDirector(newDirector);
						}
					break;
				}
				case 4:{
					int ins;
					String sourceCast,targetCast;
					while(true){
						System.out.println("Please select how you want to modify the cast");
						System.out.println("1.Add cast");
						System.out.println("2.Remove cast");
						System.out.println("3.Replace cast");
						System.out.println("4.Back");
						ins=sc.nextInt();
						sc.nextLine();
						if(ins == 1){
							System.out.println("Please enter the name of the cast you want to add in");
							sourceCast= sc.nextLine();
							for(int i = 0;i<newMList.size();i++){
								movie = newMList.get(i);
								movie.addCast(sourceCast);
							}
						}
						else if(ins == 2){
							System.out.println("Please enter the name of the cast you want to remove");
							targetCast = sc.nextLine();
							for(int i = 0;i<newMList.size();i++){
								movie = newMList.get(i);
								movie.removeCast(targetCast);
							}
						}
						else if(ins == 3){
							System.out.println("Please enter the name of the cast you want to add in");
							sourceCast= sc.nextLine();
							System.out.println("Please enter the name of the cast you want to remove");
							targetCast = sc.nextLine();
							for(int i = 0;i<newMList.size();i++){
								movie = newMList.get(i);
								movie.replaceCasts(sourceCast, targetCast);
							}
						}
						else if(ins==4)break;
						else System.out.println("Invalid instruciton");
	
						
					}
					break;
				}
				case 5: {
					for (Movie m: mList){
						m.printMovieInfo();
					}
					cineplexMgr.updateMovie(mList);
					return;
				}
				default: System.out.println("Invalid instruction");
				}
			}
		}
		else System.out.println("Not found");
	}
	
	public void changeBasePrice(){
		System.out.println("=========================================================");
		System.out.println("The current base price is " + Movie.baseRate);
		System.out.println("Please enter a new base price");
		Scanner sc = new Scanner(System.in);
		Movie.baseRate = sc.nextDouble();sc.nextLine();
	}
	public Date chooseDateWithNoTime(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("please enter the year in number");
		int year  = sc.nextInt();sc.nextLine();
		System.out.println("please enter the month in number");
		int month  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the day in number");
		int day = sc.nextInt();sc.nextLine();
		Date now = new Date();
		Date theDate = new Date(year-1900,month-1,day);
		
		try{
			FileInputStream fin = new FileInputStream("holiday.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			ArrayList<Date> holidayList;
			holidayList = (ArrayList<Date>) oin.readObject();
			oin.close();fin.close();
			if(holidayList == null)holidayList = new ArrayList<Date>();
			holidayList.add(theDate);
			System.out.println("Current Holiday List:");
			for(Date dick : holidayList){
				System.out.println(dick.toString());
			}
			FileOutputStream fout = new FileOutputStream("holiday.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fout);
			oOut.writeObject(holidayList);
		}
		catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
            e.printStackTrace();
}
		return theDate;
	}
	@SuppressWarnings("deprecation")
	public void removeDate(){
		System.out.println("=========================================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the year in number");
		int year  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the month in number");
		int month  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the day in number");
		int day = sc.nextInt();sc.nextLine();
		Date now = new Date();
		Date d = new Date(year-1900,month-1,day);
		try{
			FileInputStream fin = new FileInputStream("holiday.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			ArrayList<Date> holidayList;
			holidayList = (ArrayList<Date>) oin.readObject();
			
			System.out.println("Current Holiday List:");
			for(Date dick : holidayList){
				System.out.println(dick.toString());
			}
			
			System.out.println();
			oin.close();fin.close();
			if(holidayList == null)holidayList = new ArrayList<Date>();
			for(int i = 0;i<holidayList.size();i++){
				Date d1 = holidayList.get(i);
				if(d.getYear()==d1.getYear()&&d.getMonth()==d1.getMonth()&&d.getDate()==d1.getDate())holidayList.remove(i);
			}
			System.out.println("Updated Holiday List:");
			for(Date dick : holidayList){
				System.out.println(dick.toString());
			}
			FileOutputStream fout = new FileOutputStream("holiday.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fout);
			oOut.writeObject(holidayList);
		}
		catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
            e.printStackTrace();
}
	}
	
	@SuppressWarnings("deprecation")
	public Date chooseDateWithTime(){
		Scanner sc = new Scanner(System.in);
		Date d;
		System.out.println("=========================================================");
		System.out.println("Please enter the year in number");
		int year  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the month in number");
		int month  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the day in number");
		int day = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the hour in number");
		int hour = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the minute in number");
		int minute = sc.nextInt();sc.nextLine();
		d = new Date(year-1900,month-1,day,hour,minute);
		return d;

	}
	public void addShowing(){
		Scanner sc = new Scanner(System.in);
		ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
		cineplexList = cineplexMgr.findAllCineplex();
		Cineplex c;
		int ins;
		int numberOfCineplex = cineplexList.size();
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList = cineplexMgr.findAllMovie();
		
		while(true){
			System.out.println("=========================================================");
			int movieCnt;
			Movie m;
			String twod = "";
			for(movieCnt=1;movieCnt<=movieList.size();movieCnt++){
				m = movieList.get(movieCnt-1);
				
				if(m instanceof TwoD)
					twod = "(2D)";
				else if(m instanceof ThreeD) 
					twod = "(3D)";
				System.out.println(""+movieCnt+" Movie: "+m.getTitle()+twod);
			}
			System.out.println(""+movieCnt+" Back");
			int movieChoice = sc.nextInt();
			sc.nextLine();
			if(movieChoice ==  movieCnt) return;
			else if(movieChoice >movieCnt ||movieChoice <0)
				System.out.println("Invalid");
			else{
				m = movieList.get(movieChoice-1);
				Date d = chooseDateWithTime();
				System.out.println("There are " + numberOfCineplex + " cineplexes in total, \n"
						+ "Please enter which one/ones you want to add showing into");
				while(true){
					Iterator<Cineplex> ite = cineplexList.iterator();
					int cnt = 1;
					while(ite.hasNext()){
						c = ite.next();
						System.out.println(""+cnt+" "+ c.getName());
						cnt++;
					}
					System.out.println(""+cnt+" Back to previous");
					ins = sc.nextInt();sc.nextLine();
					if(ins == cnt) break;
					else if(ins > cnt||ins <1)
						System.out.println("Invalid");			
					else {
						c = cineplexList.get(ins-1);
						ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
						cinemaList = c.getCinemaList();
						Cinema cinema;
						int i;
						for( i = 1;i<=cinemaList.size();i++){
							cinema = cinemaList.get(i-1);
							System.out.println(""+i+" cinema with code "+cinema.getCinemaCode());
							
						}
						System.out.println(""+i+" Back");
						int instruction = sc.nextInt();
						if(instruction == i)continue;
						else if(instruction >i||instruction <=0)System.out.println("Invalid");
						else {
							cinema = cinemaList.get(instruction-1);
							ShowingSchedule showing  = new ShowingSchedule(cinema,c,m,cinema.getSeatPlan(),d);
							cineplexMgr.addShowingSchedule(showing, cinema);
							
						}
							
					}

				}
				
			}
		}
	}
}



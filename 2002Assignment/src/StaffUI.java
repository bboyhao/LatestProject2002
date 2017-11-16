import java.util.*;

public class StaffUI {
	public void DisplayMenu(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1.Change Holiday setting");
			System.out.println("2.Change ticket price setting");
			System.out.println("3.Enter a forthcoming movie");
			System.out.println("4.Update detail of a movie");
			System.out.println("5.Update status of a movie");
			System.out.println("6.List the top 5 movies by ticket sales");
			System.out.println("7.List the top 5 movies by overall ratings");
			System.out.println("8.Enter another showing");
			System.out.println("9.Exit");
			
			int instruction  = sc.nextInt();
			sc.nextLine();
			switch(instruction){
				case 1: this.chooseDateWithNoTime(); break;
				case 2: this.changeBasePrice(); break;
				case 3: this.addNewMovie(); break;
				case 4: this.updateMovieDetail(); break;
				case 5: this.updateMovieStatus(); break;
				case 6: this.listTopSale();break;
				case 7: this.listTopRating(); break;
				case 8: this.addShowing();break;
				case 9: return;
				default: System.out.println("Invalid, input again");

			}
		}
	}
	public void listTopSale(){
		ArrayList<Movie> mList= new ArrayList<Movie>();
		Movie m; MovieMgr movieMgr = new MovieMgr();
		mList = movieMgr.findTopSale();
		Iterator<Movie> ite = mList.iterator();
		System.out.println("These are the top 5 Movies with highest sale");
		int cnt = 1;
		while(ite.hasNext()){
			m=ite.next();
			System.out.println(" "+cnt + ". "+m.getTitle()+" with sales "+m.getSale() );
		}
	}
	public void listTopRating(){
		ArrayList<Movie> mList= new ArrayList<Movie>();
		Movie m;MovieMgr movieMgr = new MovieMgr();
		mList = movieMgr.findTopRating();
		Iterator<Movie> ite = mList.iterator();
		System.out.println("These are the top 5 Movies with highest Rating");
		int cnt = 1;
		while(ite.hasNext()){
			m=ite.next();
			System.out.println(" "+cnt + ". "+m.getTitle()+" with Ratings "+m.getSale() );
		}
		
	}
	public void addNewMovie(){
		Scanner sc = new Scanner(System.in);
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
		CineplexMgr mgr = new CineplexMgr();

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
				mgr.addNewMovie(m);
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
				mgr.addNewMovie(m);
				break;
			}
			else if(is3D=='N'||is3D=='n')break;
			else System.out.println("Answer Y or N only");
		}
	}
	
	public void updateMovieStatus(){
		Scanner sc = new Scanner(System.in);
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
		CineplexMgr mgr = new CineplexMgr();
//		Movie m;
		mList= mgr.findAllMovie();
		Iterator<Movie> ite = mList.iterator();
		System.out.println("see "+ mList.size());
		boolean found = false;
		for(Movie m : mList){
			System.out.println(m.getDirector());
			if(m.getTitle().equals(movieTitle)==true){
				m.setMovieStatus(status);found = true;
			}
		}
//		while(ite.hasNext()){
//			m = ite.next();
//			System.out.println(m.getDirector());
//			if(m.getTitle().equals(movieTitle)==true){
//				m.setMovieStatus(status);found  = true;
//				break;
//			}
//		}
		if(found)mgr.updateMovie(mList);
		else System.out.println("not found");
		
	}
	
	public void updateMovieDetail(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the title of the movie you want to update");
		String title = sc.nextLine();
		int instruction;
		Movie movie;
		ArrayList<Movie> mList= new ArrayList<Movie>();
		ArrayList<Movie> newMList = new ArrayList<Movie>();
		//ArrayList<TwoD> twoList = new ArrayList<TwoD>();
		//ArrayList<ThreeD>
		
		CineplexMgr mgr = new CineplexMgr();
		mList= mgr.findAllMovie();
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
					mgr.updateMovie(mList);
					return;
				}
				default: System.out.println("Invalid instruction");
				}
			}
		}
		else System.out.println("Not found");
	}
	public void changeBasePrice(){
		System.out.println("The current base price is " + Movie.baseRate);
		System.out.println("Please enter a new base price");
		Scanner sc = new Scanner(System.in);
		Movie.baseRate = sc.nextDouble();sc.nextLine();
	}
	public Date chooseDateWithNoTime(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter the month in number");
		int month  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the day in number");
		int day = sc.nextInt();sc.nextLine();
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.MONTH, month);
		myCal.set(Calendar.DAY_OF_MONTH, day);
		Date theDate = myCal.getTime();
		return theDate;
		//TODO to be continued
	}
	public Date chooseDateWithTime(){
		Scanner sc = new Scanner(System.in);
		Date d;
		System.out.println("please enter the year in number");
		int year  = sc.nextInt();sc.nextLine();
		System.out.println("please enter the month in number");
		int month  = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the day in number");
		int day = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the hour in number");
		int hour = sc.nextInt();sc.nextLine();
		System.out.println("Please enter the minute in number");
		int minute = sc.nextInt();sc.nextLine();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,year);
		c.set(Calendar.MONTH,month);
		c.set(Calendar.DAY_OF_MONTH,day);
		c.set(Calendar.HOUR_OF_DAY,hour);
		c.set(Calendar.HOUR, hour);
		d = c.getTime();
		return d;
		//TODO to be continued;
	}
	public void addShowing(){
		Scanner sc = new Scanner(System.in);
		CineplexMgr cMgr  = new CineplexMgr(); 
		ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
		cineplexList = cMgr.findAllCineplex();
		Cineplex c;
		int ins;
		int numberOfCineplex = cineplexList.size();
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList = cMgr.findAllMovie(MovieStatus.Now_Showing);
		
		
		while(true){
			int movieCnt;Movie m;String twod = "";
			for(movieCnt=1;movieCnt<=movieList.size();movieCnt++){
				m = movieList.get(movieCnt-1);
				
				if(m instanceof TwoD)twod = "(2D)";
				else if(m instanceof ThreeD) twod = "(3D)";
				System.out.println(""+movieCnt+" Movie: "+m.getTitle()+twod);
			}
			System.out.println(""+movieCnt+" Back");
			int movieChoice = sc.nextInt();
			sc.nextLine();
			if(movieChoice ==  movieCnt) return;
			else if(movieChoice >movieCnt ||movieChoice <0)System.out.println("Invalid");
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
					else if(ins > cnt||ins <1)System.out.println("Invalid");			
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
							cMgr.addShowingSchedule(showing, cinema);
							
						}
							
					}

				}
				
			}
		}
		
		
		/*hello
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
}



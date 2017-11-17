import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


//TODO add compare function in all entity classes
public class CineplexMgr {
	
	private ArrayList<Cineplex> cineplexList;
	private ArrayList<Movie> movieList;
	 
    public ArrayList<Cineplex> readInCineplex(String path){
        ArrayList<Cineplex> cList =  new ArrayList<Cineplex>();
          try {
             FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn);
             cList = (ArrayList<Cineplex>)in.readObject();
             in.close();
             fileIn.close();
          } catch (Exception e) {
                      System.out.println("Exception >>" + e.getMessage());
          }
           return cList;
    }
    
    public void writeInCineplex(String path, ArrayList<Cineplex> cList){
                    try {
             FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(cList);
             out.close();
             fileOut.close();
             System.out.println("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplexList.ser");
          } catch (IOException i) {
             i.printStackTrace();
          }
    }
    
    public ArrayList<Movie> readInMovie(String path){
        ArrayList<Movie> mList =  new ArrayList<Movie>();
          try {
             FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn);
             mList = (ArrayList<Movie>)in.readObject();
             in.close();
             fileIn.close();
          } catch (Exception e) {
                      System.out.println("Exception >>" + e.getMessage());
          }
           return mList;
    }
    
    public void writeInMovie(String path, ArrayList<Movie> mList){
                    try {
             FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(mList);
             out.close();
             fileOut.close();
             System.out.println("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplex1.ser.ser");
          } catch (IOException i) {
             i.printStackTrace();
          }
    }
	
	public ArrayList<Cineplex> findAllCineplex(){
		this.cineplexList = readInCineplex("cineplexList.ser");
		
		return this.cineplexList;
	}
	
	public ArrayList<Movie> findAllMovie(){
		this.movieList = readInMovie("Movie.ser");
		return movieList;
	}
//	public ArrayList<Movie> findAllMovie(MovieStatus status){
//		ObjectInputStream obin;
//		FileInputStream filein;
//		Movie m;
//		ArrayList<Movie> movieList=new ArrayList<Movie>();
//		try{
//			filein = new FileInputStream("Movie.ser");
//			obin = new ObjectInputStream(filein);
//			movieList = (ArrayList<Movie>)obin.readObject();
//			obin.close();filein.close();
//		}
//		catch(FileNotFoundException e1){
//			System.out.println("File does not exist");
//			return null;
//		}
//		catch(IOException e){
//			System.out.println("some io error occured");
//			e.printStackTrace();
//		}
//		catch (ClassNotFoundException e3){
//				System.out.println("somehow no such class");
//		}
//		return movieList;
//	}
	public ArrayList<ShowingSchedule> findShowingSchedule(Movie movie,Cineplex cineplex){
		ArrayList<ShowingSchedule> showingList = new ArrayList<ShowingSchedule>();

		String cineplexName = cineplex.getName();
		ArrayList<ShowingSchedule> tmpShowingList=null;

		
		this.cineplexList = readInCineplex("cineplexList.ser");
		Cineplex targetCineplex=null;
		for(int i=0;i<cineplexList.size();i++){
			if(cineplexName.equals(cineplexList.get(i).getName())){
				targetCineplex=cineplexList.get(i);
				break;
			}
		}
		for(int i=0;i<targetCineplex.getCinemaList().size();i++){
			tmpShowingList=targetCineplex.getCinemaList().get(i).getShowingList();
			for(int j=0;j<tmpShowingList.size();j++){
				if(tmpShowingList.get(j).getMovie().getTitle()==movie.getTitle()){
					showingList.add(tmpShowingList.get(j));
				}
				
			}
		}
		
		return showingList;
	}

	
	public void updateMovie(ArrayList<Movie> mList){
		writeInMovie("Movie.ser", mList);
	}
	
	public void addNewMovie(Movie movie){
		ArrayList<Movie> mList = new ArrayList<Movie>();
		mList=findAllMovie();
		mList.add(movie);
		writeInMovie("Movie.ser", mList);
	}
	
	public void removeShowingSchedule(ShowingSchedule showing,Cinema cin){
		
		ArrayList<ShowingSchedule> showingList;
		this.cineplexList = readInCineplex("cineplexList.ser");
		boolean found = false;
		for(Cineplex cplex : cineplexList){
			for(Cinema cma : cplex.getCinemaList()){
				if(cma.getCinemaCode().equals(cin.getCinemaCode())){
					if(cma.getShowingList().remove(showing)){
						found = true;							
						break;
					}
				}
			}
			if(found) break;
		}

			
		if(found)
			writeInCineplex("cineplexList.ser", cineplexList);			
	}
	
	public void removeShowingSchedule(Movie movie,Cinema cin){
			this.cineplexList = readInCineplex("cineplexList.ser");
			boolean found = false;
			for(Cineplex cplex : cineplexList){
				for(Cinema cma : cplex.getCinemaList()){
					if(cma.getCinemaCode().equals(cin.getCinemaCode())){
						ArrayList<ShowingSchedule> removeList = new ArrayList<ShowingSchedule>();
						ArrayList<ShowingSchedule> newList = cma.getShowingList();
						for(ShowingSchedule showing : newList){
							if(showing.getMovie().getTitle().equals(movie.getTitle()))removeList.add(showing);
						}
						newList.removeAll(removeList);
					}			
				}
			}
			
			writeInCineplex("cineplexList.ser", cineplexList);	
	}
	
	public void addShowingSchedule(ShowingSchedule showSche,Cinema cinema){
		ArrayList<ShowingSchedule> showingList;
		this.cineplexList = readInCineplex("cineplexList.ser");
		boolean found = false;
		for(Cineplex cplex : cineplexList){
			for(Cinema cma : cplex.getCinemaList()){					
				if(cma.getCinemaCode().equals(cinema.getCinemaCode())){
					showingList = cma.getShowingList();
					if(showingList==null){
						showingList = new ArrayList<ShowingSchedule>();}
					showingList.add(showSche);
					cma.setShowingList(showingList);	
					found = true;break;
				}
					
			}		
			if(found)break;
		}	
		writeInCineplex("cineplexList.ser", cineplexList);
	}

	public ArrayList<ShowingSchedule> findShowingSchedule(Movie movieChoice) {
		ArrayList<ShowingSchedule> showingList = new ArrayList<ShowingSchedule>();		
		
		
		

		this.cineplexList=readInCineplex("cineplexList.ser");
		for(Cineplex cplex : cineplexList){
			for(Cinema c : cplex.getCinemaList()){
				if(c.getShowingList()==null){
					continue;
				}			
				for(ShowingSchedule s:c.getShowingList()){
					if(s.getMovie().getTitle().equals(movieChoice.getTitle()) &&  s.getMovie().getClass().equals(movieChoice.getClass())){
						showingList.add(s);
					}
				}
			}
		}
		
		
		for(int i=0;i<showingList.size();i++){
			showingList.get(i).printScheduleInfo();
		}
		
		return showingList;
	}
	
	
	public void writeOutCineplex(){
		try{
			FileOutputStream fileName= new FileOutputStream("cineplexList.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileName);
			out.writeObject(this.cineplexList);
			out.close();
			fileName.close();
			System.out.println("Cineplex is updated");
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	
	

}

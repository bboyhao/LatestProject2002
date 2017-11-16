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
	
	public ArrayList<Cineplex> findAllCineplex(){
		ObjectInputStream obin;
		FileInputStream filein;
		cineplexList = new ArrayList<Cineplex>();
		Cineplex c;
		try{
			filein = new FileInputStream("Cineplex.ser");
			obin = new ObjectInputStream(filein);
			cineplexList = (ArrayList<Cineplex>)obin.readObject();
			obin.close();filein.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return null;
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("no such class");
			}
		return cineplexList;
	}
	public ArrayList<Movie> findAllMovie(){
		ObjectInputStream obin;
		FileInputStream filein;
		Movie m;
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		try{
			filein = new FileInputStream("Movie.ser");
			obin = new ObjectInputStream(filein);
			movieList = (ArrayList<Movie>)obin.readObject();
			obin.close();filein.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return null;
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		return movieList;
	}
	public ArrayList<Movie> findAllMovie(MovieStatus status){
		ObjectInputStream obin;
		FileInputStream filein;
		Movie m;
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		try{
			filein = new FileInputStream("Movie.ser");
			obin = new ObjectInputStream(filein);
			while(filein.available()>0){
				m=(Movie)obin.readObject();
				if(m.getMovieStatus()==status)movieList.add(m);
			}
			obin.close();filein.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return null;
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		return movieList;
	}
	public ArrayList<ShowingSchedule> findShowingSchedule(Movie movie,Cineplex cineplex){
		ArrayList<ShowingSchedule> showingList = new ArrayList<ShowingSchedule>();
		ObjectInputStream obin;
		FileInputStream filein;
		ArrayList<Cineplex> cineplexList= null;
		String cineplexName = cineplex.getName();
		String fileName = "cineplexList.ser";
		ArrayList<ShowingSchedule> tmpShowingList=null;
		try{
			filein= new FileInputStream(fileName);
			obin=new ObjectInputStream(filein);
			cineplexList=(ArrayList<Cineplex>)obin.readObject();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return null;
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
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
	public ArrayList<ShowingSchedule> findShowingSchedule(Cineplex cineplex){
		ArrayList<ShowingSchedule> showingList = new ArrayList<ShowingSchedule>();
		ObjectInputStream obin;
		FileInputStream filein;
		ArrayList<Cineplex> cineplexList= null;
		String cineplexName = cineplex.getName();
		String fileName = "cineplexList.ser";
		ArrayList<ShowingSchedule> tmpShowingList=null;
		try{
			filein= new FileInputStream(fileName);
			obin=new ObjectInputStream(filein);
			cineplexList=(ArrayList<Cineplex>)obin.readObject();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return null;
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
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
				showingList.add(tmpShowingList.get(j));
			}
		}
		
		return showingList;
	}
	
	public void updateMovie(ArrayList<Movie> mList){
		try{
			FileOutputStream fileout = new FileOutputStream("Movie.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fileout);
			oOut.writeObject(mList);
			oOut.close();
			fileout.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e2){
			System.out.println("some io error occured");
		}
	}
	
	public void addNewMovie(Movie movie){
		ArrayList<Movie> mList = new ArrayList<Movie>();
		mList=findAllMovie();
		mList.add(movie);
		try{
			FileOutputStream fileout = new FileOutputStream("Movie.ser");
			ObjectOutputStream objectOut=new ObjectOutputStream(fileout);
			objectOut.writeObject(mList);
			objectOut.close();
			fileout.close();
		}
		catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public void removeShowingSchedule(ShowingSchedule showing,Cinema cin){
		
		ArrayList<Cineplex> cineplexList;
		ArrayList<ShowingSchedule> showingList;
		try{
			FileInputStream fin= new FileInputStream("cineplexList.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			FileOutputStream fout = new FileOutputStream("cineplexList.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fout);
			cineplexList = (ArrayList<Cineplex>) oin.readObject();
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

			
			if(found)oOut.writeObject(cineplexList);
			oOut.close();fout.close();oin.close();fout.close();
			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		/*ArrayList<ShowingSchedule> showingList = findShowingSchedule(cin);
		String cineplexName = cin.getName();
		String fileName = cineplexName + "ShowingSchedule.txt";
		for(int i =0;i<showingList.size();i++){
			if(showingList.get(i)==showing)showingList.remove(i);
		}
		FileOutputStream fout;
		ObjectOutputStream oOut;
		try{
			fout=new FileOutputStream(fileName);
			oOut=new ObjectOutputStream(fout);
			Iterator<ShowingSchedule> iterator = showingList.iterator();
			while(iterator.hasNext()){
				oOut.writeObject(iterator.next());
			}
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}*/
		
	}
	public void removeShowingSchedule(Movie movie,Cinema cin){
		ArrayList<Cineplex> cineplexList;
		ArrayList<ShowingSchedule> showingList;
		try{
			FileInputStream fin= new FileInputStream("cineplexList.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			FileOutputStream fout = new FileOutputStream("cineplexList.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fout);
			cineplexList = (ArrayList<Cineplex>) oin.readObject();
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

			
			oOut.writeObject(cineplexList);
			oOut.close();fout.close();oin.close();fout.close();
			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		/*ArrayList<ShowingSchedule> showingList = findShowingSchedule(cin);
		String cineplexName = cin.getName();
		String fileName = cineplexName + "ShowingSchedule.txt";
		for(int i =0;i<showingList.size();i++){
			if(showingList.get(i).getMovie()==movie)showingList.remove(i);
		}
		FileOutputStream fout;
		ObjectOutputStream oOut;
		try{
			fout=new FileOutputStream(fileName);
			oOut=new ObjectOutputStream(fout);
			Iterator<ShowingSchedule> iterator = showingList.iterator();
			while(iterator.hasNext()){
				oOut.writeObject(iterator.next());
			}
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}*/
		
	}
	
	public void addShowingSchedule(ShowingSchedule showSche,Cinema cinema){
		ArrayList<Cineplex> cineplexList;
		ArrayList<ShowingSchedule> showingList;
		try{
			FileInputStream fin= new FileInputStream("cineplexList.ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			FileOutputStream fout = new FileOutputStream("cineplexList.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fout);
			cineplexList = (ArrayList<Cineplex>) oin.readObject();
			boolean found = false;
			for(Cineplex cplex : cineplexList){
				for(Cinema cma : cplex.getCinemaList()){
					if(cma.getCinemaCode().equals(cinema.getCinemaCode())){
						showingList = cma.getShowingList();
						showingList.add(showSche);
						found = true;break;
					}
				}
				if(found)break;
			}
			if(found)oOut.writeObject(cineplexList);
			oOut.close();fout.close();oin.close();fout.close();
			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		
		/*ShowingSchedule ss;
		ObjectOutputStream obout;
		FileOutputStream fileout;
		String cineplexName = cineplex.getName();
		String fileName = cineplexName + "ShowingSchedule.txt";
		ArrayList <ShowingSchedule> showSchList = findShowingSchedule(cineplex);
		showSchList.add(showSche);
		try{
			fileout = new FileOutputStream("ShowingSchedule.ser");
			obout = new ObjectOutputStream(fileout);
			int length = showSchList.size();
			for (int i=0; i<length; i++){
				obout.writeObject(showSchList.get(i));				
			}
			
			fileout.close();obout.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
			return;
		}
		catch(IOException e2){
			return;
		}*/
		
		
			
	}
	public ArrayList<ShowingSchedule> findShowingSchedule(Movie movieChoice) {
		// TODO Auto-generated method stub
		ArrayList<ShowingSchedule> showingList = new ArrayList<ShowingSchedule>();
		Cineplex tmpCineplex=null;
		
		ArrayList<Cineplex> cineplexList=null;
		ObjectInputStream obin;
		FileInputStream filein;
		String fileName = "cineplexList.ser";
		ArrayList<ShowingSchedule> tmpShowingList=null;
		try{
			filein= new FileInputStream(fileName);
			obin=new ObjectInputStream(filein);
			cineplexList=(ArrayList<Cineplex>) obin.readObject();			
		}
		catch(FileNotFoundException e1){
			System.out.println("File does not exist");
		}
		catch(IOException e){
			System.out.println("some io error occured");
		}
		catch (ClassNotFoundException e3){
				System.out.println("somehow no such class");
		}
		while(cineplexList!=null){
			tmpCineplex=cineplexList.remove(0);
			for(int i=0;i<=tmpCineplex.getCinemaList().size();i++){
				tmpShowingList=tmpCineplex.getCinemaList().get(i).getShowingList();
				for(int j=0;j<tmpShowingList.size();j++){
					if(tmpShowingList.get(j).getMovie().getTitle().equals(movieChoice.getTitle())){
						showingList.add(tmpShowingList.get(j));
					}
				}
			}
		}
		
		
		return showingList;
	}
	
	
	

}

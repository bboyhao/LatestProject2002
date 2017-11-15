import java.util.*;

public class Cineplex {
	private String name;
	private String location;
	private ArrayList<Cinema> cinemaList;
	private int numOfCinema;
	
	public Cineplex(String aName, String loc, int noCinema){
		this.setName(aName);
		this.setLocation(loc);
		this.setNumOfCinema(noCinema);
		cinemaList=new ArrayList<Cinema>();
	}
	
	public void addCinema(Cinema newCinema){
		cinemaList.add(newCinema);
	}
	
	public ArrayList<Cinema> getCinemaList(){
		return this.cinemaList;
	}
	public void removeCinema(String cinemaCode){
		for(int i=0;i<cinemaList.size();i++){
			if(cinemaList.get(i).getCinemaCode()==cinemaCode){
				cinemaList.remove(i);
				break;
			}
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumOfCinema() {
		return numOfCinema;
	}

	public void setNumOfCinema(int numOfCinema) {
		this.numOfCinema = numOfCinema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printCineplexInfo(){
		System.out.println("Cineplex Name: " + this.name);
		System.out.println("Address: " + this.location);
		System.out.println("Number of cinemas: " + this.numOfCinema);
		System.out.println("List of Cinemas");
		for (Cinema cinema: cinemaList) {
			System.out.println(cinema.getCinemaCode() + "  " + cinema.printCinemaType());
		}
		System.out.println();	
	}
}

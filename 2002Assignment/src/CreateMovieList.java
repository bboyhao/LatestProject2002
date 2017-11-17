//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//public class CreateMovieList {
//	public static void main(String[] args){
//		ArrayList<Movie> movieList=new ArrayList<Movie>();
//		
//		Movie twoD1=new TwoD();
//		twoD1.setTitle("Justics League");
//		twoD1.setSynopsis("Fueled by his restored faith in humanity and inspired by Superman's "
//				+ "selfless act, Bruce Wayne enlists the help of his newfound ally, "
//				+ "Diana Prince, to face an even greater enemy. Together, Batman and "
//				+ "Wonder Woman work quickly to find and recruit a team of metahumans to stand against "
//				+ "this newly awakened threat. But despite the formation of this unprecedented league "
//				+ "of heroes--Batman, Wonder Woman, Aquaman, Cyborg and The Flash--it may "
//				+ "already be too late to save the planet "
//				+ "from an assault of catastrophic proportions.");
//		twoD1.setMovieStatus(MovieStatus.Now_Showing);
//		ArrayList<String> casts1=new ArrayList<String>();
//		casts1.add("Ben Affleck");
//		casts1.add("Henry Cavill");
//		casts1.add("Gal Gadot");
//		twoD1.setCasts(casts1);
//		twoD1.setBBStatus();
//		twoD1.setDirector("Zack Snyder");
//		
//		Movie twoD2=new TwoD();
//		twoD2.setTitle("Ah Boys To Men 4");
//		twoD2.setSynopsis("Singapore's most successful movie franchise is back!"
//				+ " After leaving the military, Lobang, Wayang King, Sergeant "
//				+ "Ong, and Ken Chow are all busy with their respective career"
//				+ " as civilians. That's until they are called back to serve "
//				+ "the nation again under the Singapore Armed Forces' Armoured "
//				+ "Formation. Now they must juggle between work and their "
//				+ "reservist duties. What hilarious situations will happen as "
//				+ "they train together and their military roles are reversed? "
//				+ "There'll be new enemy threats and their brotherhood will be "
//				+ "put to the test.");
//		twoD2.setMovieStatus(MovieStatus.Now_Showing);
//		ArrayList<String> casts2=new ArrayList<String>();
//		casts2.add("Tosh Zhang");
//		casts2.add("Wang Weiliang");
//		casts2.add("Joshua Tan");
//		twoD2.setCasts(casts2);
//		twoD2.setDirector("Jack Neo");
//		
//		Movie twoD3=new TwoD();
//		twoD3.setTitle("Marvel's Thor: Ragnarok");
//		twoD3.setSynopsis("In Marvel Studios' \"Thor: Ragnarok\", Thor is imprisoned "
//				+ "on the other side of the universe without his mighty hammer and finds "
//				+ "himself in a race against time to get back to Asgard to stop Ragnarok- "
//				+ "the destruction of his homeworld and the end of Asgardian civilization- "
//				+ "the hands of an all-powerful new threat, the ruthless Hela. But first he "
//				+ "must survive a deadly gladiatorial contest that pits him against his former "
//				+ "ally and fellow Avenger- the Incredible Hulk!");
//		twoD3.setMovieStatus(MovieStatus.Now_Showing);
//		ArrayList<String> casts3=new ArrayList<String>();
//		casts3.add("Chris Hemsworth");
//		casts3.add("Tom Hiddleston");
//		casts3.add("Cate Blanchett");
//		twoD3.setCasts(casts3);
//		twoD3.setBBStatus();
//		twoD3.setDirector("Taika Waititi");
//		
//		Movie twoD4=new TwoD();
//		twoD4.setTitle("Pokemon The Movie: I Choose You!");
//		twoD4.setSynopsis("In the wake of the sexual revolution and the rise of"
//				+ " the women's movement, the 1973 tennismatch between women's "
//				+ "World #1 Billie Jean King (Emma Stone) and ex-men's-champ "
//				+ "and serial hustler Bobby Riggs (Steve Carell) was billed as "
//				+ "the BATTLE OF THE SEXES and became one of the most watched "
//				+ "televised sports events of all time, reaching 90 million "
//				+ "viewers around the world. As the rivalry between King and "
//				+ "Riggs kicked into high gear, off-court each was fighting "
//				+ "more personal and complex battles. The fiercely private "
//				+ "King was not only championing for equality, but also "
//				+ "struggling to come to terms with her own sexuality, as her"
//				+ " friendship with Marilyn Barnett (Andrea Riseborough) developed."
//				+ " And Riggs, one of the first self-made media-age celebrities, "
//				+ "wrestled with his gambling demons, at the expense of his "
//				+ "family and wife Priscilla (Elisabeth Shue). Together, Billie"
//				+ " and Bobby ");
//		twoD4.setMovieStatus(MovieStatus.Coming_Soon);
//		ArrayList<String> casts4=new ArrayList<String>();
//		casts4.add("Sarah Natochenny");
//		casts4.add("Rodger Parsons");
//		casts4.add("Carter Cathcart");
//		twoD4.setCasts(casts4);
//		twoD4.setDirector("Kunihiko Yuyama");
//		
//		Movie twoD5=new TwoD();
//		twoD5.setTitle("Battle Of The Sexes");
//		twoD5.setSynopsis("In the wake of the sexual revolution and the rise of "
//				+ "the women's movement, the 1973 tennismatch between women's "
//				+ "World #1 Billie Jean King (Emma Stone) and ex-men's-champ "
//				+ "and serial hustler Bobby Riggs (Steve Carell) was billed as "
//				+ "the BATTLE OF THE SEXES and became one of the most watched "
//				+ "televised sports events of all time, reaching 90 million "
//				+ "viewers around the world. As the rivalry between King and "
//				+ "Riggs kicked into high gear, off-court each was fighting "
//				+ "more personal and complex battles. The fiercely private King "
//				+ "was not only championing for equality, but also struggling "
//				+ "to come to terms with her own sexuality, as her friendship "
//				+ "with Marilyn Barnett (Andrea Riseborough) developed. "
//				+ "And Riggs, one of the first self-made media-age celebrities,"
//				+ " wrestled with his gambling demons, at the expense of his "
//				+ "family and wife Priscilla (Elisabeth Shue). Together, Billie"
//				+ " and Bobby ");
//		twoD5.setMovieStatus(MovieStatus.Coming_Soon);
//		ArrayList<String> casts5=new ArrayList<String>();
//		casts5.add("Emma Stone");
//		casts5.add("Steve Carell");
//		casts5.add("Andrea Riseborough");
//		twoD5.setCasts(casts5);
//		twoD5.setDirector("Jonathan Dayton, Valerie Faris");
//		
//		Movie threeD1=new ThreeD();
//		threeD1.setTitle("Marvel's Thor: Ragnarok");
//		threeD1.setSynopsis("In Marvel Studios' \"Thor: Ragnarok\", Thor is imprisoned "
//				+ "on the other side of the universe without his mighty hammer and finds "
//				+ "himself in a race against time to get back to Asgard to stop Ragnarok- "
//				+ "the destruction of his homeworld and the end of Asgardian civilization- "
//				+ "the hands of an all-powerful new threat, the ruthless Hela. But first he "
//				+ "must survive a deadly gladiatorial contest that pits him against his former "
//				+ "ally and fellow Avenger- the Incredible Hulk!");
//		threeD1.setMovieStatus(MovieStatus.Now_Showing);
//		ArrayList<String> casts6=new ArrayList<String>();
//		casts6.add("Chris Hemsworth");
//		casts6.add("Tom Hiddleston");
//		casts6.add("Cate Blanchett");
//		threeD1.setCasts(casts6);
//		threeD1.setBBStatus();
//		threeD1.setDirector("Taika Waititi");
//		
//		Movie threeD2=new ThreeD();
//		threeD2.setTitle("Justics League");
//		threeD2.setSynopsis("Fueled by his restored faith in humanity and inspired by Superman's "
//				+ "selfless act, Bruce Wayne enlists the help of his newfound ally, "
//				+ "Diana Prince, to face an even greater enemy. Together, Batman and "
//				+ "Wonder Woman work quickly to find and recruit a team of metahumans to stand against "
//				+ "this newly awakened threat. But despite the formation of this unprecedented league "
//				+ "of heroes--Batman, Wonder Woman, Aquaman, Cyborg and The Flash--it may "
//				+ "already be too late to save the planet "
//				+ "from an assault of catastrophic proportions.");
//		threeD2.setMovieStatus(MovieStatus.Now_Showing);
//		ArrayList<String> casts7=new ArrayList<String>();
//		casts7.add("Ben Affleck");
//		casts7.add("Henry Cavill");
//		casts7.add("Gal Gadot");
//		threeD2.setCasts(casts7);
//		threeD2.setBBStatus();
//		threeD2.setDirector("Zack Snyder");
//		
//		movieList.add(threeD2);
//		movieList.add(threeD1);
//		movieList.add(twoD5);
//		movieList.add(twoD4);
//		movieList.add(twoD3);
//		movieList.add(twoD2);
//		movieList.add(twoD1);
//		
//		try{
//			FileOutputStream fileout = new FileOutputStream("Movie.ser");
//			ObjectOutputStream out = new ObjectOutputStream(fileout);
//			out.writeObject(movieList);
//			out.close();
//			fileout.close();
//			System.out.println("Movie.ser is created!");
//		}catch (IOException i) {
//	         i.printStackTrace();
//	      }
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//}

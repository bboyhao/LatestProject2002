//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//public class CreateMovieObjects {
//	public static void main(String args[]){
//		Cineplex cineplex1=new Cineplex("CinePlex@Jurong Point","Jurong Point",3);
//		Cineplex cineplex2=new Cineplex("CinePlex@Bugis","Jurong Point",3);
//		Cineplex cineplex3=new Cineplex("CinePlex@Serangoon","Serangoon",3);
//		ArrayList<Cinema> arrayListOfCinemas1=new ArrayList<Cinema>();
//		ArrayList<Cinema> arrayListOfCinemas2=new ArrayList<Cinema>();
//		ArrayList<Cinema> arrayListOfCinemas3=new ArrayList<Cinema>();
//		Dolby dolby1=new Dolby();
//		Dolby dolby2=new Dolby();
//		Dolby dolby3=new Dolby();
//		Dolby dolby4=new Dolby();
//		Dolby dolby5=new Dolby();
//		Dolby dolby6=new Dolby();
//		Platinum platinum1=new Platinum();
//		Platinum platinum2=new Platinum();
//		Platinum platinum3=new Platinum();
//		arrayListOfCinemas1.add(dolby6);
//		arrayListOfCinemas1.add(dolby5);
//		arrayListOfCinemas2.add(dolby4);
//		arrayListOfCinemas2.add(dolby3);
//		arrayListOfCinemas3.add(dolby2);
//		arrayListOfCinemas3.add(dolby1);
//		arrayListOfCinemas1.add(platinum1);
//		arrayListOfCinemas2.add(platinum2);
//		arrayListOfCinemas3.add(platinum3);
//		cineplex1.setCinemaList(arrayListOfCinemas3);
//		cineplex2.setCinemaList(arrayListOfCinemas2);
//		cineplex3.setCinemaList(arrayListOfCinemas1);
//		try {
//	         FileOutputStream fileOut =
//	         new FileOutputStream("C:/Users/WUHA0/Desktop/cineplex1.ser");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(cineplex1);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplex1.ser.ser");
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	      }
//		try {
//	         FileOutputStream fileOut =
//	         new FileOutputStream("C:/Users/WUHA0/Desktop/cineplex2.ser");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(cineplex2);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplex2.ser");
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	      }
//		try {
//	         FileOutputStream fileOut =
//	         new FileOutputStream("C:/Users/WUHA0/Desktop/cineplex3.ser");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(cineplex3);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplex3.ser");
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	      }
//	}
//}
//

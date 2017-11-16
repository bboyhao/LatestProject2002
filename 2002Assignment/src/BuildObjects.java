import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BuildObjects {
//	public static void main(String args[]){
//		ArrayList<Cineplex> cineplexList=new ArrayList<Cineplex>();
//		Cineplex cineplex1=new Cineplex("CinePlex@Jurong Point","Jurong Point",0);
//		Cineplex cineplex2=new Cineplex("CinePlex@Bugis","Bugis",0);
//		Cineplex cineplex3=new Cineplex("CinePlex@Serangoon","Serangoon",0);
//		cineplexList.add(cineplex1);
//		cineplexList.add(cineplex2);
//		cineplexList.add(cineplex3);
//		Dolby dolby1 = new Dolby();
//		dolby1.setCinemaCode("J1D");
//		Dolby dolby2 = new Dolby();
//		dolby2.setCinemaCode("J2D");
//
//		Dolby dolby3 = new Dolby();
//		dolby3.setCinemaCode("B1D");
//
//		Dolby dolby4 = new Dolby();
//		dolby4.setCinemaCode("B2D");
//
//		Dolby dolby5 = new Dolby();
//		dolby5.setCinemaCode("S1D");
//
//		Dolby dolby6 = new Dolby();		
//		dolby6.setCinemaCode("S2D");
//
//
//		Platinum platinum1 = new Platinum();
//		platinum1.setCinemaCode("J3P");
//		Platinum platinum2 = new Platinum();
//		platinum2.setCinemaCode("B3P");
//		Platinum platinum3 = new Platinum();
//		platinum3.setCinemaCode("S3P");
//
//		cineplex1.addCinema(dolby1);
//		cineplex1.addCinema(dolby2);
//		cineplex1.addCinema(platinum1);
//		
//		cineplex2.addCinema(dolby3);
//		cineplex2.addCinema(dolby4);
//		cineplex2.addCinema(platinum2);
//		
//		cineplex3.addCinema(dolby5);
//		cineplex3.addCinema(dolby6);
//		cineplex3.addCinema(platinum3);
//		
//		
//		SeatPlan planA=new SeatPlan(1);
//		SeatPlan planB=new SeatPlan(2);
//		dolby1.setSeatPlan(planA);
//		dolby2.setSeatPlan(planA);
//		dolby3.setSeatPlan(planA);
//		dolby4.setSeatPlan(planA);
//		dolby5.setSeatPlan(planA);
//		dolby6.setSeatPlan(planA);
//
//		
//		platinum1.setSeatPlan(planB);
//		platinum2.setSeatPlan(planB);
//		platinum3.setSeatPlan(planB);
//		try{
//			FileOutputStream fileout = new FileOutputStream("cineplexList.ser");
//			ObjectOutputStream out = new ObjectOutputStream(fileout);
//			out.writeObject(cineplexList);
//			out.close();
//			fileout.close();
//			System.out.println("cineplexList is ceated!");
//		}catch (IOException i) {
//	         i.printStackTrace();
//	      }
		
//		char seatArray[][]=new char[10][23] ;
//		String fileName = "C:/Users/WUHA0/Desktop/seatplan/seatplan2.txt";
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = 
//                new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = 
//                new BufferedReader(fileReader);
//
//            for(int i=0;i<10;i++){
//            	String thisline=bufferedReader.readLine();
//            	System.out.println(thisline);
//            	for(int j=0;j<23;j++){
//            		seatArray[i][j]=thisline.charAt(j);
//            	}
//            }
//            for(int i=0;i<10;i++){
//            	for(int j=0;j<23;j++){
//            		System.out.print(seatArray[i][j]);
//            	}
//            	System.out.println();
//            }
//            // Always close files.
//            bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                "Unable to open file '" + 
//                fileName + "'");                
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error reading file '" 
//                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
//        }
//		
//		
//		
//		try {
//	         FileOutputStream fileOut =
//	         new FileOutputStream("C:/Users/WUHA0/Desktop/seatplan/seatplan2.ser");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(seatArray);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in C:/Users/WUHA0/Desktop/seatplan/seatplan2.ser");
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	      }
		// The name of the file to open.
//		char[][] newArray=null;
//		try {
//	         FileInputStream fileIn = new FileInputStream("C:/Users/WUHA0/Desktop/seatplan/seatplan2.ser");
//	         ObjectInputStream in = new ObjectInputStream(fileIn);
//	         newArray = (char[][]) in.readObject();
//	         in.close();
//	         fileIn.close();
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	         return;
//	      } catch (ClassNotFoundException c) {
//	         System.out.println("Employee class not found");
//	         c.printStackTrace();
//	         return;
//	      }
//		for(int i=0;i<10;i++){
//			for(int j=0;j<23;j++){
//				System.out.print(newArray[i][j]);
//			}
//			System.out.println();

//		}
		
    }



	



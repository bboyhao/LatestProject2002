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
import java.util.Date;

public class BuildObjects {
	public static void main(String args[]){
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
//            // Or we could just do this: 
//            // ex.printStackTrace();
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
		Date date=new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmm");
    	System.out.println(ft.format(date));
    }
}


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class SeatPlan {
	private char[][] seatPlan;
	public SeatPlan(int choice){
		switch(choice){
		case 1:
			String fileName="C:/Users/WUHA0/Desktop/seatplan/seatplan1.txt";
			try {
				
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);
	
	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	
	            for(int i=0;i<10;i++){
	            	String thisline=bufferedReader.readLine();
	            	System.out.println(thisline);
	            	for(int j=0;j<23;j++){
	            		seatPlan[i][j]=thisline.charAt(j);
	            	}
	           }
	        }catch(FileNotFoundException ex) {
	            System.out.println(
              "Unable to open file '" + 
              fileName + "'");                
	        }catch(IOException ex) {
	        	System.out.println("Error reading file '" + fileName + "'");                  
	        	}
			break;
			
			
		case 2:
			String fileName1="C:/Users/WUHA0/Desktop/seatplan/seatplan2.txt";
			try {
				
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName1);
	
	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	
	            for(int i=0;i<10;i++){
	            	String thisline=bufferedReader.readLine();
	            	System.out.println(thisline);
	            	for(int j=0;j<23;j++){
	            		seatPlan[i][j]=thisline.charAt(j);
	            	}
	           }
	        }catch(FileNotFoundException ex) {
	            System.out.println(
              "Unable to open file '" + 
              fileName1 + "'");                
	        }catch(IOException ex) {
	        	System.out.println("Error reading file '" + fileName1 + "'");                  
	        	}
			break;
		default:
			System.out.println("wrong input");
				
		}
	}
	public char[][] getSeatPlan(){
		return seatPlan;
	}
	public void printSeatPlan(){
		for(int i = 0;i<seatPlan.length;i++){
			for(int j =0;j<seatPlan[0].length;j++){
				System.out.print(seatPlan[i][j]);
			}
			System.out.print('\n');
			}
	}
	public void updateSeatPlan(int row,int col){
		seatPlan[row][col]='X';
			
	}
}

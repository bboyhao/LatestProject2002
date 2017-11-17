import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class MovieMgr implements Serializable{
                
                private ArrayList<Movie> movieList;

                
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
                         System.out.printf("Serialized data is saved in C:/Users/WUHA0/Desktop/cineplex1.ser.ser");
                      } catch (IOException i) {
                         i.printStackTrace();
                      }
                }

                public ArrayList<Movie> findMovie(String movieTitle){
                   
                                ArrayList<Movie> resultList = new ArrayList<Movie>();

                                try          {
                                                this.movieList = readInMovie("Movie.ser");
                                                
                                                for (int i = 0; i < movieList.size(); i++){
                                                        if (movieList.get(i).getTitle().equals(movieTitle))
                                                              resultList.add(this.movieList.get(i));
                                                }
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return resultList;
                                
                }

                public ArrayList<Movie> findNowShowing(){
                                ArrayList<Movie> nowShowing = new ArrayList<Movie>();
                                try          {
                                                this.movieList = readInMovie("Movie.ser");
                                               
                                                for (int i = 0 ; i < movieList.size() ; i++) {
                                                                Movie m = (Movie)movieList.get(i);
                                                                if (m.getMovieStatus() == MovieStatus.Now_Showing)
                                                                                nowShowing.add(m);
                                                }
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                                e.printStackTrace();
                                }
                                return nowShowing;
                }
                
                public ArrayList<Movie> findComingSoon(){
                    ArrayList<Movie> comingSoon = new ArrayList<Movie>();
           
                	try          {
                                                this.movieList = readInMovie("Movie.ser");
                                                System.out.println("==========Coming Soon==========");
                                                for (int i = 0 ; i < movieList.size() ; i++) {
                                                                Movie m = (Movie)movieList.get(i);
                                                                if (m.getMovieStatus() == MovieStatus.Coming_Soon)
                                                                                comingSoon.add(m);
                                                }                                                              
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return comingSoon;
                }
                
                public ArrayList<Movie> findTopSale(){
                                ArrayList<Movie> top5 = new ArrayList<Movie>();
                                
                                try          {
                                                this.movieList = readInMovie("Movie.ser");
                                                for(int i =0;i<movieList.size();i++){
                                                	for(int j = 0;j<movieList.size()-1;j++){
                                                		Movie m = movieList.get(j);
                                                		if(m.getSale()<movieList.get(j+1).getSale()){
                                                			movieList.remove(j);
                                                			movieList.add(j+1,m);
                                                		}
                                                	}
                                                }
                                                if(movieList.size()<5) {
                                                	for(int i = 0;i<movieList.size();i++)top5.add(movieList.get(i));
                                                }
                                                else for(int i =0;i<5;i++)top5.add(movieList.get(i)); 
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return top5;
                }


                public ArrayList<Movie> findTopRating(){
                                ArrayList<Movie> top5 = new ArrayList<Movie>();
                                
                                try          {
                                                this.movieList = readInMovie("Movie.ser");

                                                for(int i =0;i<movieList.size();i++){
                                                	for(int j = 0;j<movieList.size()-1;j++){
                                                		Movie m = movieList.get(j);
                                                		if(m.getOverallRating()<movieList.get(j+1).getOverallRating()){
                                                			movieList.remove(j);
                                                			movieList.add(j+1,m);
                                                		}
                                                	}
                                                }
                                                
                                                if(movieList.size()<5) {
                                                	for(int i = 0;i<movieList.size();i++)
                                                		top5.add(movieList.get(i));
                                                }
                                                else for(int i =0;i<5;i++)
                                                	top5.add(movieList.get(i));

                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                                e.printStackTrace();
                                }
                                return top5;

                }
                
                
                public void createReview(MovieGoer movieGoer, Movie m, String review, int rating){
                                
                                Review r = new Review(movieGoer, review, rating);
                                
                                m.updateReviews(r);
                                
                }
                
                public void writeOutMovie(){
            		try{
            			FileOutputStream fileName= new FileOutputStream("Movie.ser");
            			ObjectOutputStream out = new ObjectOutputStream(fileName);
            			out.writeObject(this.movieList);
            			out.close();
            			fileName.close();
            			System.out.println("Movie.ser is updated");
            		}catch(IOException i){
            			i.printStackTrace();
            		}
            	}
}


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
                         FileOutputStream fileOut =
                         new FileOutputStream(path);
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
                                int targetLength;
                                int sourceLength = movieTitle.length();
                                ArrayList<Movie> resultList = new ArrayList<Movie>();

                                try          {
                                                // read from serialized file the list of movies
                                                this.movieList = readInMovie("Movie.ser");
                                                
                                                for (int i = 0; i < movieList.size(); i++){
                                                                targetLength = movieList.get(i).getTitle().length();
                                                                for (int k = 0; k <= (targetLength - sourceLength); k++)
                                                                                if (movieList.get(i).getTitle().regionMatches(k, movieTitle, 0, sourceLength))
                                                                                                resultList.add(this.movieList.get(i));
                                                }
                                                return resultList;
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return resultList;
                                
                }

                public ArrayList<Movie> findNowShowing(){
                                ArrayList<Movie> nowShowing = new ArrayList<Movie>();
                                try          {
                                                // read from serialized file the list of movies
                                                this.movieList = readInMovie("Movie.ser");
                                               
                                                for (int i = 0 ; i < movieList.size() ; i++) {
                                                                Movie m = (Movie)movieList.get(i);
                                                                m.printMovieInfo();
                                                                if (m.getMovieStatus() == MovieStatus.Now_Showing)
                                                                                nowShowing.add(m);
                                                                				
                                                }
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return nowShowing;
                }
                
                public ArrayList<Movie> findComingSoon(){
                    ArrayList<Movie> comingSoon = new ArrayList<Movie>();
           
                	try          {
                                                // read from serialized file the list of movies
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
                
                
//                public static Comparator<Movie> MovieSaleComparator = new Comparator<Movie>() {
//                                public int compare(Movie m1, Movie m2) {
//                                	System.out.println("enter");
//                                   double movieSale1 = m1.getSale();
//                                   double movieSale2 = m2.getSale();
//                                   return (int)(movieSale2-movieSale1);  
//                    }
//                };
                
                public ArrayList<Movie> findTopSale(){
                                ArrayList<Movie> top5 = new ArrayList<Movie>();
                                
                                try          {
                                                this.movieList = readInMovie("Movie.ser");
                                                //Collections.sort(movieList, MovieMgr.MovieSaleComparator);

                                                System.out.println("====="
                                                		+ "=====Top Five Movies By Sales==========");
                                                for (int i = 0 ; i < 5 ; i++) {
                                                                Movie m = movieList.get(i);
                                                                top5.add(m);
                                                                m.printMovieInfo();
                                                }
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return top5;
                }
                
//                public static Comparator<Movie> MovieRatingComparator = new Comparator<Movie>() {
//
//                                public int compare(Movie m1, Movie m2) {
//                                   double movieRating1 = m1.getSale();
//                                   double movieRating2 = m2.getSale();
//                                   return (int)(movieRating2-movieRating1);
//                    }
//                };

                public ArrayList<Movie> findTopRating(){
                                ArrayList<Movie> top5 = new ArrayList<Movie>();
                                
                                try          {
                                                this.movieList = readInMovie("Movie.ser");
                                                //Collections.sort(movieList, MovieMgr.MovieRatingComparator);
                                
                                                System.out.println("==========Top Five Movies By Rating==========");
                                                for (int i = 0 ; i < 5 ; i++) {
                                                                Movie m = (Movie)movieList.get(i);
                                                                top5.add(m);
                                                                m.printMovieInfo();
                                                }
                                } catch ( Exception e ) {
                                                System.out.println( "Exception >> " + e.getMessage() );
                                }
                                return top5;

                }
                
                
                public void createReview(MovieGoer movieGoer, Movie m, String review, int rating){
                                
                                this.movieList = readInMovie("Movie.ser");
                                // add to list
                                
//                                
//                                Scanner sc = new Scanner(System.in);
//                                                                
//                                System.out.println("Enter review: ");
//                                String review = sc.next();
//                                
//                                System.out.println("Enter rating (1-10):");
//                                int rating = sc.nextInt();
                                
                                Review r = new Review(movieGoer, review, rating);
                                
                                int index = movieList.indexOf(m);


                                m.updateReviews(r);
                                
                                movieList.set(index,m);
                                
                                writeInMovie("Movie.ser", movieList);

                }
                
                public void updateTitle(Movie m, String newT){
//                                Scanner sc = new Scanner(System.in);
//                                
//                                System.out.println("Enter new movie title: ");
//                                String newT = sc.next();
                	
                				int index = movieList.indexOf(m);

                                m.setTitle(newT);
                                
                                movieList.set(index,m);
                                
                                writeInMovie("Movie.ser", movieList);

                }
                
                public void updateStatus(Movie m, int index){
//                                Scanner sc = new Scanner(System.in);
//
//                                int index = movieList.indexOf(m);
//                                
//                                System.out.println("Enter new movie status:");
//                                System.out.println("1. Coming Soon");
//                                System.out.println("2. Now Showing");
//                                System.out.println("3. End of Showing");
//                                int statusChoice = sc.nextInt();
//                                MovieStatus status = MovieStatus.values()[statusChoice-1];
//                                m.setMovieStatus(status);
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                
                public void updateSynopsis(Movie m, String newS){
//                                Scanner sc = new Scanner(System.in);
//
//                                
//                                System.out.println("Enter new movie synopsis:");
//                                String newS = sc.next();
                				int index= movieList.indexOf(m);

                                m.setSynopsis(newS);
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                                
                public void updateDirector(Movie m, String newD){
//                                Scanner sc = new Scanner(System.in);
//                                
//
//                                System.out.println("Enter new movie director:");
//                                String newD = sc.next();
                				int index = movieList.indexOf(m);

                                m.setDirector(newD);
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                
                public void updateCasts(Movie m, String currentC, String newC){
//                                Scanner sc = new Scanner(System.in);
//                                
//
//                                System.out.println("Which actor to replace:");
//                                String currentC = sc.next();
//                                System.out.println("Enter new cast:");
//                                String newC = sc.next();
                    			int index = movieList.indexOf(m);

                                m.replaceCasts(newC, currentC);
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                
                public void addCast(Movie m, String newC){
//                                Scanner sc = new Scanner(System.in);
//                                
//                               
//                                
//                                System.out.println("Enter new cast:");
//                                String newC = sc.next();
                				int index = movieList.indexOf(m);
                                
                				m.addCast(newC);
                                
                                this.movieList.set(index,m);
                                writeInMovie("Movie.ser", this.movieList);
                }
                
                public void removeCast(Movie m, String removeC){
//                                Scanner sc = new Scanner(System.in);
//                                
//                                
//
//                                System.out.println("Enter name of cast to be removed:");
//                                String removeC = sc.next();
                                m.removeCast(removeC);
                                
                                int index = movieList.indexOf(m);
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                
                public void updateBBStatus(Movie m){
//                                Scanner sc = new Scanner(System.in);
                                
                                int index = movieList.indexOf(m);

                                m.setBBStatus();
                                
                                movieList.set(index,m);
                                writeInMovie("Movie.ser", movieList);
                }
                
                public static void updateBBRate(double bbRate){
//                                Scanner sc = new Scanner(System.in);
//                                System.out.println("====Update Block Buster Rate=====");
//                
//                                System.out.println("Enter new Block Buster Rate:");
//                                double bbRate = sc.nextDouble();
                                Movie.setBBRate(bbRate);
                }
                
                public static void updateBaseRate(double bRate){
//                                Scanner sc = new Scanner(System.in);
//                                System.out.println("====Update Base Rate=====");
//                
//                                System.out.println("Enter new Base Rate:");
//                                double bRate = sc.nextDouble();
                                Movie.setBaseRate(bRate);
                }
                
                public static void updateTwoDRate(double rate){
//                                Scanner sc = new Scanner(System.in);
//                                System.out.println("====Update 2D Rate=====");
//                
//                                System.out.println("Enter new 2D Rate:");
//                                double rate = sc.nextDouble();
                                TwoD.setClassRate(rate);
                }
                
                public static void updateThreeDRate(double rate){
//                                Scanner sc = new Scanner(System.in);
//                                System.out.println("====Update 3D Rate=====");
//                
//                                System.out.println("Enter new 3D Rate:");
//                                double rate = sc.nextDouble();
                                ThreeD.setClassRate(rate);
                }
                                                
                
                public void newMovie(String movieTitle, String synopsis, String director, ArrayList<String> casts){
                                this.movieList = readInMovie("Movie.ser");
                                
                                Scanner sc = new Scanner(System.in);
//                                                                                                
//                                System.out.println("Enter new movie title:");
//                                String movieTitle = sc.next();
//                                
//                                System.out.println("Enter new movie status:");
//                                System.out.println("1. Coming Soon");
//                                System.out.println("2. Now Showing");
//                                System.out.println("3. End of Showing");
//                                int statusChoice = sc.nextInt();
//                                
//                                System.out.println("Enter new movie synopsis:");
//                                String synopsis = sc.next();
//                                
//                                System.out.println("Enter new movie director:");
//                                String director = sc.next();
//                                
//                                
//                                System.out.println("Enter number of casts: ");
//                                int n = sc.nextInt();
//                                ArrayList<String> casts = new ArrayList<String>();
//                                String cast;
//                                
//                                for (int i = 0; i<n; i++){
//                                                System.out.println("Name of new cast:");
//                                                cast = sc.next();
//                                                casts.add(cast);
//                                }
//                                
//                                System.out.println("Enter block buster status:");
//                                Boolean bbstatus = sc.nextBoolean();
                                
                                System.out.println("2D available? [Y/N]");
                                String twod = sc.nextLine();
                                if (twod.equals("Y")||twod.equals("y")){
                                                TwoD m2 = newTwoD(movieTitle, synopsis, director, casts);
                                                movieList.add(m2);
                                }
                                
                                System.out.println("3D available? [Y/N]");
                                String threed = sc.nextLine();
                                if (threed.equals("Y")||threed.equals("y")){
                                                ThreeD m3 = newThreeD(movieTitle, synopsis, director, casts);
                                                movieList.add(m3);
                                }
                                
                                // add to list
                }
                
                private TwoD newTwoD(String movieTitle, String synopsis, String director, ArrayList<String> casts){
                                
                                
                                TwoD m = new TwoD();
                                
                                m.setSynopsis(synopsis);
                                
                                m.setDirector(director);
                                
                                for (int i = 0; i<casts.size(); i++){
                                                m.addCast(casts.get(i));
                                }
                                                                
                                return m;
                }
                
                private ThreeD newThreeD(String movieTitle, String synopsis, String director, ArrayList<String> casts){
                                ThreeD m = new ThreeD();
                                
                                m.setTitle(movieTitle);
                                                                
                                m.setSynopsis(synopsis);
                                
                                m.setDirector(director);
                                
                                for (int i = 0; i<casts.size(); i++){
                                                m.addCast(casts.get(i));
                                }
                                                                
                                return m;
                }
}


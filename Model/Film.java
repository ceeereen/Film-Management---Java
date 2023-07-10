package Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;







public class Film {

    

    private String filmName;
    private int year; 
    private String director;
    private double imdb;
    //needs to define category toString too since this toString method gives referense to its
    private ArrayList<Category> categoryArray;
    private ArrayList<Platform> platformList;
    private String showTimes;//gösterim saatleri
    private ArrayList<Film> filmList = new ArrayList<>();//?
    Scanner scanner = new Scanner(System.in);

    

    public void enterFilm() {

        System.out.println("How many films do you want to enter?");
        int numFilm = Integer.parseInt(scanner.nextLine());
        ArrayList<Film> initialList = new ArrayList<>();

        for (int i = 0; i < numFilm; i++) {
         // Boyut ataması yapılıyor
           Film film = new Film();
            
            System.out.println("Enter film name: ");
            String filmName = scanner.nextLine();
            System.out.println("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter director: ");
            String director = scanner.nextLine();  
            System.out.println("Enter imdb score: ");
            double imdb = scanner.nextDouble();

            // create category according to select
            System.out.println("Enter the number that matches film's category: ");
            for (int j = 0; j < Main.categoryList.size(); j++) {
                System.out.println((j + 1) + ". " + Main.categoryList.get(j));
            }
            int categoryNum = scanner.nextInt() -1 ;
            Main.categoryList.get(categoryNum);
            ArrayList<Category> categoriesList = new ArrayList<>();
            categoriesList.add(Main.categoryList.get(categoryNum));//copies selected category from categoryList in Main.

            //create platform list from Main that entered by admin
            ArrayList<Platform> platformsList = selectPlatforms();
            scanner.nextLine();
            
            System.out.println("Enter the show times: ");
            String showTimes = scanner.nextLine();
            
            initialList.add(new Film(filmName, year, director, imdb, categoriesList, platformsList, showTimes));
        }
        filmList.addAll(initialList);
        System.out.println(filmList);
        
    }

    //select platforms from Main.platformList to platformList of Film
    private ArrayList<Platform> selectPlatforms() {
        ArrayList<Platform> platformsList = new ArrayList<>();
        System.out.println("List of digital platforms: ");
        for (int j = 0; j < Main.platformList.size(); j++) {
            System.out.println((j + 1) + ". " + Main.platformList.get(j));
        }
        
        System.out.println("How many platforms do you want to add to your film?");
        int platformNum = scanner.nextInt();

        for(int i = 0; i<platformNum; i++){
            System.out.println("Enter the platform number do you want to add: ");
            int selectedNum = scanner.nextInt() - 1;
            platformsList.add(Main.platformList.get(selectedNum));
        }
    
        return platformsList;
    }
    
    
    
   
  

    public ArrayList<Film> getFilmList() {
        return filmList;
    }





    public void setFilmList(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }





    @Override
    public String toString() {
        return "Film [filmName=" + filmName + ", year=" + year + ", director=" + director + ", imdb=" + imdb
                + ", categoryArray=" + categoryArray + ", platformList=" + platformList + ", showTimes=" + showTimes
                + "]";
    }


    public Film(String filmName, int year, String director, double imdb, ArrayList<Category> categoryArray,
            ArrayList<Platform> platformList, String showTimes) {
        this.filmName = filmName;
        this.year = year;
        this.director = director;
        this.imdb = imdb;
        this.categoryArray = categoryArray;
        this.platformList = platformList;
        this.showTimes = showTimes;
    }

    
    public ArrayList<Category> getCategoryArray() {
        return categoryArray;
    }






    public void setCategoryArray(ArrayList<Category> categoryArray) {
        this.categoryArray = categoryArray;
    }






    public String getFilmName() {
        return filmName;
    }


    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }


   
    public String getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes;
    }

    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }


    public double getImdb() {
        return imdb;
    }


    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public Film(){ };


   

    public String getTime() {
        return showTimes;
    }


    public void setTime(String showTimes) {
        this.showTimes = showTimes;
    }


    public ArrayList<Platform> getPlatformList() {
        return platformList;
    }


    public void setPlatformList(ArrayList<Platform> platformList) {
        this.platformList = platformList;
    }


    public Film(String filmName, int year, String director) {
        this.filmName = filmName;
        this.year = year;
        this.director = director;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    
   

    
    
    


}

package Model;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Category> categoryList = new ArrayList<>(); //stores categories that admin entered
    public static ArrayList<Platform> platformList = new ArrayList<>(); //stores plaforms that admin entered
    public static ArrayList<Film> filmList = new ArrayList<>(); //stores films that admin entered

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Film film = new Film();
        Category category = new Category();
        Platform platform = new Platform();
        int selectLoginType;

        System.out.println("Welcome to Film Management Platform!");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Return to Menu");
            System.out.println("0. Exit Program");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    selectLoginType = 1;
                    adminLogin(selectLoginType);
                    break;
                case 2:
                    selectLoginType = 2;
                    userLogin(selectLoginType);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    //When admin logged in enters category, platform, film
    public static void adminLogin(int selectLoginType) {
        Scanner scanner = new Scanner(System.in);
        Film film = new Film();
        Category category = new Category();
        Platform platform = new Platform();
        

        categoryList.addAll(category.displayCategoryList()); //categoryList saved with entries of admin
        platformList.addAll(platform.displayPlatformList()); //platformList saved with entries of admin
        film.enterFilm();
        filmList.addAll(film.getFilmList());
        //incrase filmCount by looping over filmlist, categories in films of filmList, and matching categoryList in main
        for (Film f : film.getFilmList()) {
            for (Category c : f.getCategoryArray()) {
                for (Category categoryInList : categoryList) {
                    if (categoryInList.getName().equalsIgnoreCase(c.getName())) {
                        categoryInList.incrementFilmCount();
                        break;
                    }
                }
            }
        }

        System.out.println("**********");
        System.out.println("Category List:");
        for (Category c : categoryList) {
            System.out.println(c.getName());
        }
        System.out.println("**********");
        System.out.println("Platform List:");
        for (Platform p : platformList) {
            System.out.println(p.getName());
        }
        System.out.println("**********");
        System.out.println("Film List:");
        for (Film f : filmList) {
            System.out.println(f.getFilmName());
        }
        System.out.println("**********");
    }

    public static void userLogin(int selectLoginType) {
        if (filmList.isEmpty()) {
            System.out.println("There is no film entered by admin please wait.");
        } else {
            System.out.println("User entered");
    
            System.out.println("Category List:");
            for (Category c : categoryList) {
                System.out.println("Film count of category " + c.getName() + " is: " + c.getFilmCount());
            }
    
            Scanner scanner = new Scanner(System.in);
            //category name must be written //kategori ismi yazılmalı
            System.out.println("Type! the category name: ");
            String selectedCategory = scanner.nextLine();
    
            System.out.println("Category: " + selectedCategory);
            boolean categoryExists = false;

            //ig selected category matches categories of the films in the Film list, display the film.
            for (Film f : filmList) {
                for (Category c : f.getCategoryArray()) {
                    if (c.getName().equalsIgnoreCase(selectedCategory)) {
                        System.out.println(f.toString());
                        categoryExists = true;
                        break;
                    }
                }
            }
    
            if (!categoryExists) {
                System.out.println("There is no film in this category.");
            }
    
            System.out.println("**********");
        }
    }
    
    
}

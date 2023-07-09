package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Category {
    

    private String name;

    private int filmCount; //toDo
    

    public Category(String name){
        this.name =name;
    }
     public Category(){ }



    Scanner scanner = new Scanner(System.in);

    
    //admin enters categories
    public  ArrayList<Category> displayCategoryList() {
        System.out.println("How many categories do you want to enter?: ");
        int categoryNum = Integer.parseInt(scanner.nextLine());
        ArrayList<Category> categoryList = new ArrayList<>();
    
        for (int i = 0; i < categoryNum; i++) {
            System.out.println("Enter category name: ");
            String categoryName = scanner.nextLine();
            categoryList.add(new Category(categoryName));
        }
    
        return categoryList;
    }

    //it increase filmCount category based while admin enters film
    public void incrementFilmCount() {
        filmCount++;
    }

    
    
    @Override
    public String toString() {
        return "Category [name=" + name + ", filmCount=" + filmCount + "]";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }
   
    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
   
  
   

    

}

package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Platform {



     private String name;


     Scanner scanner = new Scanner(System.in);

   

    //admin enters platforms
    public ArrayList<Platform> displayPlatformList(){

        System.out.println("How many platforms do you want to enter?: ");
        int platformNum = Integer.parseInt(scanner.nextLine());//prevents nextLine intervene before

        ArrayList<Platform> platformList = new ArrayList<Platform>();

         for (int i = 0; i < platformNum; i++) {
            System.out.println("Enter platform name: ");
            String platformName = scanner.nextLine();
            platformList.add(new Platform(platformName));
        }
        return platformList;      

    }
    
   


    @Override
    public String toString() {
        return "Platform [name=" + name + "]";
    }




    public Platform() {}

    
    public Platform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}

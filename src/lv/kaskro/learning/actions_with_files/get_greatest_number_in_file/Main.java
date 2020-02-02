package lv.kaskro.learning.actions_with_files.get_greatest_number_in_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int largest = -1;
        String pathToFile;
        try {
            System.out.println("Please enter path to file:");
            Scanner scanner =  new Scanner(System.in);
            pathToFile = scanner.nextLine();
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.next();
                try{
                    if(largest == -1) {
                        largest = Integer.parseInt(data);
                    } else if (Integer.parseInt(data) > largest){
                        largest = Integer.parseInt(data);
                    }
                } catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        System.out.println(largest);
    }
}

package lv.kaskro.learning.actions_with_files.count_numbers_from_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        String pathToFile;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter path to file: ");
            pathToFile = scanner.nextLine();
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.next();
                try{
                    if(Integer.parseInt(data) >= 9999)
                        count++;
                } catch (Exception e){
                    System.out.println("Error : Can't convert to int: " + data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        System.out.println(count);
    }
}

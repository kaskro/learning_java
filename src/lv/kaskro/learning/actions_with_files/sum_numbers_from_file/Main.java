package lv.kaskro.learning.actions_with_files.sum_numbers_from_file;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String pathToFile;
        try {
            System.out.println("Please enter path to file:");
            Scanner scanner =  new Scanner(System.in);
            pathToFile = scanner.nextLine();
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try{
                    sum += Integer.parseInt(data);
                } catch (Exception e){
                    System.out.println("Error : Can't convert to int: " + data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
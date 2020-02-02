package lv.kaskro.learning.actions_with_files.count_even_numbers_in_file;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        int temp;
        String pathToFile;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter path to file: ");
            pathToFile = scanner.nextLine();
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try{
                    temp = Integer.parseInt(data);
                    if(temp == 0) {
                        break;
                    } else if (temp % 2 == 0){
                        count++;
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
        System.out.println(count);
    }
}

package lv.kaskro.learning.actions_with_files.get_year_of_population;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        String[] temp;
        int year = 0;
        long lastPopulation;
        long biggestDifference;
        String pathToFile;
        try {
            System.out.println("Please enter path to file:");
            Scanner scanner = new Scanner(System.in);
            pathToFile = scanner.nextLine();
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                temp = data.split("\t");
                data = temp[0] + " " + temp[1].replaceAll("," , "");
                arr.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        try{
            temp = arr.get(1).split(" ");
            year = Integer.parseInt(temp[0]);
            lastPopulation = Long.parseLong(temp[1]);
            biggestDifference = -1;
            for(int i = 1; i < arr.size() - 1; i++){
                temp = arr.get(i+1).split(" ");
                if (Long.parseLong(temp[1]) - lastPopulation  >  biggestDifference) {
                    biggestDifference = Long.parseLong(temp[1]) - lastPopulation;
                    year = Integer.parseInt(temp[0]);
                }
                lastPopulation = Long.parseLong(temp[1]);
            }
        } catch (Exception e){
            System.out.println("Error: " +  e.getMessage());
        }
        System.out.println(year);
    }
}

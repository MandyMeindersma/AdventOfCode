package DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int totalNumber = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                totalNumber += findValidNumber(data);
            }
            System.out.println(totalNumber);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Integer findValidNumber(String data) {
        return 0;
    }


    
}

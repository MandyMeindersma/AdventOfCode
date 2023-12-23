package DayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int totalNumber = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                totalNumber += findCardScore(data);
            }
            System.out.println(totalNumber);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Integer findCardScore(String data) {
        String values = data.split(":")[1];
        String[] winningAndNumbers = values.split("|");
        List<String> winning = Arrays.asList(winningAndNumbers[0].split(" "));

        for (String number : winningAndNumbers[1].split(" ")) {
            
        }
        return 0;
    }
    
}

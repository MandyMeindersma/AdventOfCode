package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class DayTwo {

        private static final Map<String, Integer> colourMax = Map.of("red", 12, "green", 13, "blue", 14);

        public static void main(String[] args) {
            try {
                File input = new File("input.txt");
                Scanner myReader = new Scanner(input);
                int totalNumber = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    totalNumber += findGames(data);
                }
                System.out.println(totalNumber);
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }   

        public static int findGames(String string) {
            System.out.println();
            System.out.println(string);

            String gameIndex = string.substring(5,string.indexOf(":"));
            string = string.split(":")[1];
            String[] handfuls = string.split(";");
            boolean canPlay = true;
            for (String handful : handfuls) {
                String[] colours = handful.split(",");
                for (String colour : colours) {
                    String[] pair = colour.substring(1,colour.length()).split(" ");
                    
                    if (colourMax.get(pair[1]) >= Integer.parseInt(pair[0])) {
                        canPlay = canPlay & true;
                        
                    } else {
                        canPlay = canPlay & false;
                    }          
                }
            }
            if (canPlay) { 
                return Integer.parseInt(gameIndex);
            }
            return 0;
        }
    
}

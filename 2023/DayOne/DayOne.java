package DayOne;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class DayOne {

    private static final String[] NUMBERS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner myReader = new Scanner(input);
            int totalNumber = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                totalNumber += findNumber(data);
            }
            System.out.println(totalNumber);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static Integer findNumber(String string) {

        string = replaceStringNumbers(string);

        StringBuilder sb = new StringBuilder();
        for (Character character : string.toCharArray()) {
            try {
                Integer.parseInt(character.toString());
                sb.append(character);
                break;
            } 
            catch (NumberFormatException e) {
                ;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.reverse();
        for (Character character : sb2.toString().toCharArray()) {
            try {
                Integer.parseInt(character.toString());
                sb.append(character);
                break;
            } 
            catch (NumberFormatException e) {
                ;
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static String replaceStringNumbers(String string) {
        System.out.println();
        System.out.println(string);

        int offset = 0;
        boolean foundFirst = false;

        while (foundFirst == false && offset < string.length()) {
            for (int i = 0; i < NUMBERS.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                if (string.length() > (offset + NUMBERS[i].length()) && string.substring(offset, offset+NUMBERS[i].length()).equals(NUMBERS[i])) {
                    foundFirst = true;
                    sb.append(string.substring(0,offset+1));
                    sb.append(i+1);
                    sb.append(string.substring(offset-1+NUMBERS[i].length(),string.length()));
                    string = sb.toString();
                    System.out.println(string);
                    break;
                }
                
            }
            offset+=1;
        }

        offset = string.length();
        foundFirst = false;

        while (foundFirst == false && offset > 1) {
            for (int i = 0; i < NUMBERS.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                if (0 < (offset - NUMBERS[i].length()) && string.substring(offset-NUMBERS[i].length(), offset).equals(NUMBERS[i])) {
                    foundFirst = true;
                    sb.append(string.substring(0,offset-NUMBERS[i].length()+1));
                    sb.append(i+1);
                    sb.append(string.substring(offset-1,string.length()));
                    string = sb.toString();
                    System.out.println(string);
                    break;
                }
                
            }
            offset-=1;
        }


        
        return string;
    }
}
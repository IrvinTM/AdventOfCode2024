package day3;

import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String filepath = "data.txt";
        int sum = 0;
        boolean dont = false;
        boolean matchFound = false;
        try {
            String currentString = "";
            Pattern pattern = Pattern.compile("[m][u][l]\\((\\d{0,4}),(\\d{0,4})\\)");
            Pattern pattern2 = Pattern.compile("don't\\(\\)");
            Pattern pattern3 = Pattern.compile("do\\(\\)");

            FileReader file = new FileReader(filepath);
            int s;
            while ((s = file.read()) != -1) {
                currentString = currentString.concat(Character.toString((char) s));
                Matcher matchDont = pattern2.matcher(currentString);
                Matcher matchdo = pattern3.matcher(currentString);
                Matcher matchMul = pattern.matcher(currentString);
                matchFound = matchMul.find();

                if (matchFound && !dont) {
                    sum += Integer.parseInt(matchMul.group(1)) * Integer.parseInt(matchMul.group(2));
                    currentString = "";
                }
                if (matchDont.find()) {
                    dont = true;
                }
                if (matchdo.find()) {
                    dont = false;
                    currentString = "";
                }

            }
            System.out.println("Final file :=================================================== ");
            System.out.println(currentString);
            System.out.println("the sum is " + sum);
            file.close();

        } catch (Exception e) {
            System.out.println("Execption papu" + e);

        }
    }

}

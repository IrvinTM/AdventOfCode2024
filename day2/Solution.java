package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        System.out.println(safeReports());

    }

    static int safeReports() {
        int totalSafe = 0;

        String filePath = "data_day2.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = br.readLine()) != null) {

                boolean ascendant = false;

                String[] numbers = line.trim().split(" ");
                System.out.println("the len is" + numbers.length);

                for (int i = 0; i < numbers.length - 1; i++) {
                    if (Integer.parseInt(numbers[i]) + 1 == Integer.parseInt(numbers[i + 1])
                            || Integer.parseInt(numbers[i]) + 2 == Integer.parseInt(numbers[i + 1])
                            || Integer.parseInt(numbers[i]) + 3 == Integer.parseInt(numbers[i + 1])) {

                        ascendant = true;
                        System.out.println("true");

                    } else {
                        ascendant = false;
                        break;
                    }
                }
                if (ascendant) {
                    totalSafe += 1;
                    // checamos los descendentes
                } else {
                    for (int i = 0; i < numbers.length - 1; i++) {
                        if (Integer.parseInt(numbers[i]) - 1 == Integer.parseInt(numbers[i + 1])
                                || Integer.parseInt(numbers[i]) - 2 == Integer.parseInt(numbers[i + 1])
                                || Integer.parseInt(numbers[i]) - 3 == Integer.parseInt(numbers[i + 1])) {

                            ascendant = true;

                        } else {
                            ascendant = false;
                            break;
                        }
                    }
                    if (ascendant) {
                        totalSafe += 1;
                    }
                }

            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return totalSafe;
    }

}

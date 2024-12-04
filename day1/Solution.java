package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7, 9, 3, 5 };
        String path = "data.txt";

        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                column1.add(Integer.parseInt(numbers[0]));
                column2.add(Integer.parseInt(numbers[1]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(getDifferences(column1, column2));

    }

    static int getDifferences(List<Integer> array1, List<Integer> array2) {
        Collections.sort(array1);
        Collections.sort(array2);
        List<Integer> list = new ArrayList<Integer>();

        int count = 0;

        while (count < array1.size() && count < array2.size()) {
            list.add(Math.abs(array1.get(count) - array2.get(count)));
            count++;

        }
        int sum = 0;

        for (int e : list) {
            sum += e;

        }
        return sum;
    }

}
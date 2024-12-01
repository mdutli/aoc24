package day01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SolOne {

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        Collections.sort(list1);
        Collections.sort(list2);
        int total = 0;
        for (int i = 0; i < list1.size(); i++) {
            total += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(total);
    }

    private static void readFile() {
        try {
            File myObj = new File("src/day01/input.txt");
            Scanner myReader = new Scanner(myObj);
            // only works because we know we always have pairs
            while (myReader.hasNextInt()) {
                list1.add(myReader.nextInt());
                list2.add(myReader.nextInt());
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}



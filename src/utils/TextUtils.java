package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUtils {


    public static List<String[]> readFileLines(String path, String splitRegex) {
        List<String[]> output = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                output.add(myReader.nextLine().split(splitRegex));
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return output;
    }
}
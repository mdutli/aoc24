package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    public static List<String[]> readFileLines(String path, String splitRegex) {
        List<String[]> output = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(path))) {
            while (fileReader.hasNextLine()) {
                output.add(fileReader.nextLine().split(splitRegex));
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return output;
    }

    public static List<String> readFileWhole(String path, String matchRegex) {
        List<String> output = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {

            Pattern pattern = Pattern.compile(matchRegex);

            // Use findWithinHorizon to search for the pattern in the entire input
            while (scanner.findWithinHorizon(pattern, 0) != null) {
                Matcher matcher = pattern.matcher(scanner.match().group());
                if (matcher.find()) {
                    output.add(matcher.group());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        return output;
    }
}
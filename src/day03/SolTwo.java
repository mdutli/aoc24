package day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.TextUtils;

public class SolTwo {

    public static void main(String[] args) {
        List<String> inputs = TextUtils.readFileWhole("src/day03/input.txt", "(mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\))");
        boolean mode = true;
        int total = 0;
        for (String input : inputs) {
            if (input.equals("don't()")) {
                mode = false;
            }
            if (input.equals("do()")) {
                mode = true;
            }
            if (mode) {
                total += multiplyValues(input);
            }
        }
        System.out.println(total);
    }

    private static int multiplyValues(String matchedString) {
        String numberRegex = "([0-9]{1,3}),([0-9]{1,3})";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(matchedString);
        if (numberMatcher.find()) {
            return Integer.parseInt(numberMatcher.group(1)) * Integer.parseInt(numberMatcher.group(2));
        }
        return 0;
    }
}

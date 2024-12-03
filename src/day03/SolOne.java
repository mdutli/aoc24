package day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import utils.TextUtils;

public class SolOne {
    public static void main(String[] args) {
        List<String> inputs = TextUtils.readFileWhole("src/day03/input.txt", "(mul\\([0-9]{1,3},[0-9]{1,3}\\))");

        System.out.println((Integer)inputs.stream().map(SolOne::multiplyValues).mapToInt(Integer::intValue).sum());
    }

    private static int multiplyValues(String matchedString) {
        String numberRegex = "([0-9]{1,3}),([0-9]{1,3})";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(matchedString);
        if (numberMatcher.find()) {
            System.out.println(numberMatcher.group(1));
            System.out.println(numberMatcher.group(2));
            return Integer.parseInt(numberMatcher.group(1)) * Integer.parseInt(numberMatcher.group(2));
        }
        return 0;
    }

}



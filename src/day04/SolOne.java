package day04;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.TextUtils;

public class SolOne {
    public static void main(String[] args) {
        List<String[]> inputs = TextUtils.readFileLines("src/day04/input.txt", "");
        String[][] matrix = new String[inputs.size()][inputs.getFirst()[0].length()];
        for (int i = 0; i < inputs.size(); i++) {
            matrix[i] = inputs.get(i);
        }
        Pattern pattern = Pattern.compile("XMAS");

        int total = 0;
        total += checkRows(matrix, pattern, false);
        total += checkRows(matrix, pattern, true);
        total += checkColumns(matrix, pattern, false);
        total += checkColumns(matrix, pattern, true);
        total += checkDiagonal(matrix, pattern, false);
        total += checkDiagonal(matrix, pattern, true);
        total += checkDiagonalOpposite(matrix, pattern, false);
        total += checkDiagonalOpposite(matrix, pattern, true);
        System.out.println(total);
    }

    private static int checkRows(String[][] matrix, Pattern pattern, boolean reversed) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                col.append(matrix[i][j]);
            }
            Matcher matcher = pattern.matcher(reversed ? col.reverse().toString() : col.toString());
            while (matcher.find()) {
                count++;
            }
        }
        return count;
    }

    private static int checkColumns(String[][] matrix, Pattern pattern, boolean reversed) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                col.append(matrix[j][i]);
            }

            Matcher matcher = pattern.matcher(reversed ? col.reverse().toString() : col.toString());
            while (matcher.find()) {
                count++;
            }
        }
        return count;
    }

    private static int checkDiagonal(String[][] matrix, Pattern pattern, boolean reversed) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int start = 3; start < matrix.length; start++) {
            int x = 0;
            int y = start;
            while (x < matrix.length && y >= 0) {
                result.append(matrix[y][x]);
                x++;
                y--;
            }
            result.append("|");
        }
        for (int start = 1; start < matrix.length - 3; start++) {
            int x = start;
            int y = matrix.length - 1;
            while (x < matrix.length && y >= 0) {
                result.append(matrix[y][x]);
                x++;
                y--;
            }
            result.append("|");
        }
        Matcher matcher = pattern.matcher(reversed ? result.reverse().toString() : result.toString());
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int checkDiagonalOpposite(String[][] matrix, Pattern pattern, boolean reversed) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int start = 3; start < matrix.length; start++) {
            int y = matrix.length - 1;
            int x = start;
            while (y < matrix.length && x >= 0) {
                result.append(matrix[y][x]);
                y--;
                x--;
            }
            result.append("|");
        }
        for (int start = matrix.length - 2; start >= 3; start--) {
            int y = start;
            int x = matrix.length - 1;
            while (y >= 0 && x >= 0) {
                result.append(matrix[y][x]);
                x--;
                y--;
            }
            result.append("|");
        }
        Matcher matcher = pattern.matcher(reversed ? result.reverse().toString() : result.toString());
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}



package day04;

import java.util.List;
import java.util.regex.Matcher;

import utils.TextUtils;

public class SolTwo {

    public static void main(String[] args) {
        List<String[]> inputs = TextUtils.readFileLines("src/day04/input.txt", "");
        String[][] matrix = new String[inputs.size()][inputs.getFirst()[0].length()];
        for (int i = 0; i < inputs.size(); i++) {
            matrix[i] = inputs.get(i);
        }
        int count = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (y > 0 && x > 0) {
                    if (matrix[y][x].equals("A")) {
                        if (checkM(matrix, y, x) && checkS(matrix, y, x)) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean checkS(String[][] matrix, int x, int y) {
        if (matrix[x + 1][y - 1].equals("S") || matrix[x + 1][y + 1].equals("S")) {
            return true;
        }
        return false;
    }

    private static boolean checkM(String[][] matrix, int x, int y) {
        if (matrix[x - 1][y - 1].equals("M") || matrix[x - 1][y + 1].equals("M")) {
            return true;
        }
        return false;
    }
}

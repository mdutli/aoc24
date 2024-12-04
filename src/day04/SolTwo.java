package day04;

import utils.TextUtils;

import java.util.List;

public class SolTwo {

    public static void main(String[] args) {
        List<String[]> inputs = TextUtils.readFileLines("src/day04/input.txt", "");
        String[][] matrix = new String[inputs.size()][inputs.getFirst()[0].length()];
        for (int i = 0; i < inputs.size(); i++) {
            matrix[i] = inputs.get(i);
        }
        int count = 0;
        for (int y = 1; y < matrix.length - 1; y++) {
            for (int x = 1; x < matrix[y].length - 1; x++) {
                if (matrix[y][x].equals("A")) {
                    if (checkSurroundings(matrix, x, y)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean checkSurroundings(String[][] matrix, int x, int y) {
        String lT = matrix[y - 1][x - 1];
        String lD = matrix[y + 1][x - 1];
        String rT = matrix[y - 1][x + 1];
        String rD = matrix[y + 1][x + 1];
        if (lT.equals(rD) || lD.equals(rT)) {
            return false;
        }
        return lT.matches("[MS]") && lD.matches("[MS]") && rT.matches("[MS]") && rD.matches("[MS]");
    }
}

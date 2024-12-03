package day03;

import java.util.Arrays;
import java.util.List;

import utils.TextUtils;

public class SolOne {

    public static void main(String[] args) {
        List<String[]> inputs = TextUtils.readFileLines("src/day02/input.txt", " ");
        int safeLevelsCounter = 0;
        for (String[] inputLevel : inputs) {
            int[] level = Arrays.stream(inputLevel).mapToInt(Integer::parseInt).toArray();
            if (isLevelSafe(level)) {
                safeLevelsCounter++;
            }
        }
        System.out.println(safeLevelsCounter);
    }

    private static boolean isLevelSafe(int[] level) {
        boolean isAscending = level[0] < level[1];
        for (int i = 0; i + 1 < level.length; i++) {
            int thisValue = level[i];
            int nextValue = level[i + 1];
            int diff = Math.abs(thisValue - nextValue);
            if (isAscending && !(thisValue < nextValue && diff <= 3)) {
                return false;
            } else if (!isAscending && !(thisValue > nextValue && diff <= 3)) {
                return false;
            }
        }
        return true;
    }
}



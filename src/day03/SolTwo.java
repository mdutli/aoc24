package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import utils.TextUtils;

public class SolTwo {

    public static void main(String[] args) {
        List<String[]> inputs = TextUtils.readFileLines("src/day02/input.txt", " ");
        AtomicInteger safeLevelsCounter = new AtomicInteger();
        inputs.forEach(line -> {
            int[] level = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            if (isLevelSafe(level) || isModifiedLevelSafe(level)) {
                safeLevelsCounter.getAndIncrement();
            }
        });
        System.out.println(safeLevelsCounter.get());
    }

    private static boolean isModifiedLevelSafe(int[] level) {
        for (int i = 0; i < level.length; i++) {
            int[] modifiedLine = buildModifiedLine(level, i);
            if (isLevelSafe(modifiedLine)) {
                return true;
            }
        }
        return false;
    }

    private static int[] buildModifiedLine(int[] level, int i) {
        ArrayList<Integer> modifiedLine = new ArrayList<>();
        for (int j = 0; j < level.length; j++) {
            if (i != j) {
                modifiedLine.add(level[j]);
            }
        }
        return modifiedLine.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isLevelSafe(int[] level) {
        boolean isAscending = false;
        int previous = -1;
        for (int i = 0; i < level.length; i++) {
            int current = level[i];
            if (i == 0) {
                previous = current;
            } else {
                int diff = current - previous;
                int diffAbs = Math.abs(diff);
                if (diffAbs < 1 || diffAbs > 3) {
                    return false;
                }

                if (i == 1) {
                    isAscending = (diff > 0);
                } else {
                    if (isAscending && diff < 0) {
                        return false;
                    }
                    if (!isAscending && diff > 0) {
                        return false;
                    }
                }
                previous = current;
            }
        }
        return true;
    }
}

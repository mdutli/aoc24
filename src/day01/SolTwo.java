package day01;

import utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class SolTwo {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        TextUtils.readFileLines("src/day01/input.txt", " {3}").forEach(line -> {
            list1.add(Integer.parseInt(line[0]));
            list2.add(Integer.parseInt(line[1]));
        });
        int similarityScore = 0;
        int amount = 0;
        for (int val1 : list1) {
            for (int val2 : list2) {
                if (val1 == val2) {
                    amount++;
                }
            }
            if (amount != 0) {
                similarityScore += val1 * amount;
                amount = 0;
            }
        }
        System.out.println(similarityScore);
    }
}

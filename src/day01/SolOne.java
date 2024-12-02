package day01;

import utils.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolOne {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        TextUtils.readFileLines("src/day01/input.txt", " {3}").forEach(line -> {
            list1.add(Integer.parseInt(line[0]));
            list2.add(Integer.parseInt(line[1]));
        });
        Collections.sort(list1);
        Collections.sort(list2);
        int total = 0;
        for (int i = 0; i < list1.size(); i++) {
            total += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(total);
    }
}



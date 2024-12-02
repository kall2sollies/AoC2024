package kall.aoc2024.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kall.Shared.BaseExercise;

public class Day01Second extends BaseExercise {
    public Day01Second() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\01_2.txt");
    }

    public String run() throws Exception {

        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();

        for (String line : getLines()) {
            String[] segments = line.split(" ");

            var left = Integer.parseInt(Arrays.stream(segments).findFirst().get());
            var right = Integer.parseInt(Arrays.stream(segments).reduce((x, y) -> y).get());

            leftList.add(left);
            rightList.add(right);
        }

        leftList.sort(null);
        rightList.sort(null);

        Integer totalSimilarity = 0;

        for(int i = 0 ; i < leftList.size() ; i++) {
            int similarity = leftList.get(i) * Collections.frequency(rightList, leftList.get(i));

            totalSimilarity += similarity;
        }

        return totalSimilarity.toString();
    }
}

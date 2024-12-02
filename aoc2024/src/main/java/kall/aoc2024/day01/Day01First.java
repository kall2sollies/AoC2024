package kall.aoc2024.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kall.Shared.BaseExercise;

public class Day01First extends BaseExercise {
    public Day01First() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\01_1.txt");
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

        Integer totalDifference = 0;

        for(int i = 0 ; i < leftList.size() ; i++) {
            int difference = Math.abs(rightList.get(i) - leftList.get(i));

            totalDifference += difference;
        }

        return totalDifference.toString();
    }
}

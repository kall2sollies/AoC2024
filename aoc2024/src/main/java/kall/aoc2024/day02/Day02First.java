package kall.aoc2024.day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kall.Shared.BaseExercise;

public class Day02First extends BaseExercise {
    public Day02First() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\02_1.txt");
    }

    public String run() throws Exception {
        
        List<List<Integer>> matrix = Arrays.asList(getLines()).stream()
            .map(x -> Arrays.asList(x.split(" "))
                .stream()
                .map(s -> Integer.parseInt(s))
                .toList())
            .toList();

        Integer validLines = 0;

        for (List<Integer> list : matrix) {

            Boolean isSorted = isSorted(list);
            Integer smallestDifference = findSmallestAdjacentDifference(list);
            Integer greatestDifference = findGretestAdjacentDifference(list);
            boolean isValid = isSorted && smallestDifference >= 1 && greatestDifference <= 3;

            if (isValid) {
                validLines++;
            }

            System.out.println(joinAsString(list) + " " + (isValid ? "safe " : "unsafe ") + "sorted=" + isSorted.toString() + " smallest=" + smallestDifference.toString() + " greatest=" + greatestDifference.toString());
        }

        return validLines.toString();
    }

    private static boolean isSorted(List<Integer> list) {
        return list.stream().sorted().toList().equals(list)
            || list.stream().sorted(Comparator.reverseOrder()).toList().equals(list);
    }

    private static int findSmallestAdjacentDifference(List<Integer> list) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0 ; i < list.size() - 1 ; i++) {
            int difference = Math.abs(list.get(i + 1) - list.get(i));
            if (difference < smallest) {
                smallest = difference;
            }
        }

        return smallest;
    }

    private static int findGretestAdjacentDifference(List<Integer> list) {
        int greatest = 0;

        for (int i = 0 ; i < list.size() - 1 ; i++) {
            int difference = Math.abs(list.get(i + 1) - list.get(i));
            if (difference > greatest) {
                greatest = difference;
            }
        }
        
        return greatest;
    }

    private static String joinAsString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }
}

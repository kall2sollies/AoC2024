package kall.aoc2024.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kall.Shared.BaseExercise;

public class Day02Second extends BaseExercise {
    public Day02Second() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\02_2.txt");
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

            if (isValid(list)) {
                validLines++;
            } else if (isValidByRemovingOneElement(list)) {
                validLines++;
            }
        }

        return validLines.toString();
    }

    private static boolean isValid(List<Integer> list) {
        Boolean isSorted = isSorted(list);
        Integer smallestDifference = findSmallestAdjacentDifference(list);
        Integer greatestDifference = findGretestAdjacentDifference(list);

        boolean isValid = isSorted && smallestDifference >= 1 && greatestDifference <= 3;

        return isValid;
    }

    private static boolean isValidByRemovingOneElement(List<Integer> list) {

        for (int indexOfRemovedItem = 0 ; indexOfRemovedItem < list.size() ; indexOfRemovedItem++) {
            List<Integer> reducedList = new ArrayList<>();

            for (int indexInInitialList = 0 ; indexInInitialList < list.size() ; indexInInitialList++) {
                if (indexInInitialList != indexOfRemovedItem) {
                    reducedList.add(list.get(indexInInitialList));
                }
            }

            if (isValid(reducedList)) {
                return true;
            }
        }

        return false;
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

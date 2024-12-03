package kall.aoc2024.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kall.Shared.BaseExercise;

public class Day03Second extends BaseExercise {

    public Day03Second() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\03_2.txt");
    }

    public String run() throws Exception {

        String data = String.join("", getLines());
        List<String> rawOperations = extractOperations(data);

        boolean isEnabled = true;
        List<String> filteredOperations = new ArrayList<>();
        for (String op : rawOperations) {
            
            if (isEnabled && op.startsWith("mul")) {
                filteredOperations.add(op);
            }

            if (op.startsWith("don")) {
                isEnabled = false;
            }

            if (op.startsWith("do(")) {
                isEnabled = true;
            }
        }
        
        Integer sum = filteredOperations // [mul(1,2);mul(3;4)]
            .stream().map(o -> extractInner(o)).flatMap(List::stream).toList() // ["1,2";"3,4"]
            .stream().map(x -> extractNumbers(x)).toList() // [[1,2];[3,4]]
            .stream().map(x -> multiply(x)).toList() // [2,12]
            .stream().reduce(0, (a, b) -> a + b); // 24
        
        return sum.toString();
    }

    private static List<String> extractOperations(String data) {
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don\'t\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            String match = matcher.group();
            matches.add(match);
        }

        return matches;
    }

    private static List<String> extractInner(String expression) {
        String regex = "\\d{1,3},\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            String match = matcher.group();
            matches.add(match);
        }

        return matches;
    }

    private static List<Integer> extractNumbers(String expression) {
        String regex = "\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        List<Integer> matches = new ArrayList<>();

        while (matcher.find()) {
            String match = matcher.group();
            matches.add(Integer.parseInt(match));
        }

        return matches;
    }

    private static int multiply(List<Integer> integers) {
        int result = 1;
        for (Integer integer : integers) {
            result *= integer;
        }
        return result;
    }
}
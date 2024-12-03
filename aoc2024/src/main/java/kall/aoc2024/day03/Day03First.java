package kall.aoc2024.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kall.Shared.BaseExercise;

public class Day03First extends BaseExercise {

    public Day03First() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\03_1.txt");
    }

    public String run() throws Exception {

        String data = String.join("", getLines());

        Integer sum = extractOperations(data).stream() // [mul(1,2);mul(3;4)]
            .map(o -> extractInner(o))
            .flatMap(List::stream)
            .toList() // ["1,2";"3,4"]
            .stream()
            .map(x -> extractNumbers(x))
            .toList()
            .stream()
            .map(x -> multiply(x)).toList().stream().reduce(0, (a, b) -> a + b);



        return sum.toString();
    }

    private static List<String> extractOperations(String data) {
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
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
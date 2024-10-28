package baekjoon.b2752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(Integer.parseInt(input));
        }
        numbers.sort(Comparator.naturalOrder());
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}

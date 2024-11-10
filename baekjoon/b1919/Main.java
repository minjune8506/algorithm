package baekjoon.b1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < y.length(); i++) {
            char c = y.charAt(i);
            m.put(c, m.getOrDefault(c, 0) - 1);
        }

        int answer = 0;
        for (int value : m.values()) {
            answer += Math.abs(value);
        }
        System.out.println(answer);
    }
}

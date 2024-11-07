package baekjoon.b11328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Map<Character, Integer> m = new HashMap<>();
            String[] words = br.readLine().split(" ");
            String src = words[0];
            String dst = words[1];

            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                m.put(c, m.getOrDefault(c, 0) + 1);
            }

            boolean success = true;
            for (int i = 0; i < dst.length(); i++) {
                char c = dst.charAt(i);
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) - 1);
                    continue;
                }
                success = false;
            }

            for (Integer value : m.values()) {
                if (value != 0) {
                    success = false;
                    break;
                }
            }
            if (success) {
                System.out.println("Possible");
                continue;
            }
            System.out.println("Impossible");
        }

    }
}

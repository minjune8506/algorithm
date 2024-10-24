package baekjoon.b7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        // 로그가 주어졌을때 현재 회사에 있는 모든 사람
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Map<String, Boolean> log = new TreeMap<>(Comparator.reverseOrder());
        while (count-- > 0) {
            String[] words = br.readLine().split(" ");
            String key = words[0];
            boolean value = words[1].equals("enter");
            log.put(key, value);
        }

        var sb = new StringBuilder();
        for (var entry : log.entrySet()) {
            if (Boolean.TRUE.equals(entry.getValue())) {
                sb.append(entry.getKey());
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}

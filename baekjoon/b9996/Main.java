package baekjoon.b9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String start = "";
        String end = "";
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                start = pattern.substring(0, i);
                end = pattern.substring(i + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (cnt-- > 0) {
            String fileName = br.readLine();
            if (start.length() + end.length() > fileName.length()) {
                sb.append("NE\n");
                continue;
            }

            if (fileName.startsWith(start) && fileName.endsWith(end)) {
                sb.append("DA\n");
                continue;
            }
            sb.append("NE\n");
        }
        System.out.print(sb);
    }
}

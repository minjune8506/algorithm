package baekjoon.b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            int[] ary = new int[k];
            for (int i = 0; i < k; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }

            bruteForce(ary, 0, 0, sb, "");
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void bruteForce(int[] ary, int idx, int cnt, StringBuilder sb, String numbers) {
        if (cnt == 6) {
            sb.append(numbers)
                .append('\n');
            return;
        }
        for (int i = idx; i < ary.length; i++) {
            bruteForce(ary, i + 1, cnt + 1, sb, numbers + ary[i] + " ");
        }
    }
}

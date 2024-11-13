package baekjoon.b15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] ary;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ary = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        sb = new StringBuilder();
        pick(0, "");
        System.out.print(sb);
    }

    static void pick(int cnt, String output) {
        if (cnt == m) {
            sb.append(output).append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            pick(cnt + 1, output + ary[i] + " ");
        }
    }
}

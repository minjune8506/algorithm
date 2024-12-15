package baekjoon.b14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] info = new int[n][2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[idx][0] = Integer.parseInt(st.nextToken());
            info[idx][1] = Integer.parseInt(st.nextToken());
            idx++;
        }

        System.out.print(bruteForce(info, 0, 0, n));

    }

    private static int bruteForce(int[][] info, int current, int earn, int n) {
        int max = earn;
        for (int i = current; i < info.length; i++) {
            int time = info[i][0];
            int profit = info[i][1];

            if (i + time <= n) {
                max = Math.max(max, bruteForce(info, i + time, earn + profit, n));
            }
        }
        return max;
    }
}

package baekjoon.b12852;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] dp = new int[x + 1];
        int[] trace = new int[x + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= x; i++) {
            int min = i - 1;
            trace[i] = i - 1;
            if (i % 2 == 0) {
                if (dp[i / 2] < dp[min]) {
                    min = i / 2;
                    trace[i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[i / 3] < dp[min]) {
                    min = i / 3;
                    trace[i] = i / 3;
                }
            }
            dp[i] = dp[min] + 1;
        }
        System.out.println(dp[x]);

        printTrace(x, trace);
    }

    private static void printTrace(int x, int[] trace) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x).append(' ');
            if (x == 1) {
                break;
            }
            x = trace[x];
        }
        System.out.print(sb);
    }
}

package baekjoon.b15990;

import java.util.Scanner;

public class Main {
    private static final int MAX_VALUE = 100001;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        long[][] dp = new long[MAX_VALUE][3];
        dp[1][0] = 1L;
        dp[2][1] = 1L;
        dp[3][0] = dp[3][1] = dp[3][2] = 1L;

        for (int i = 4; i < MAX_VALUE; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            int n = sc.nextInt();
            long sum = dp[n][0] + dp[n][1] + dp[n][2];
            if (sum >= 1_000_000_009) {
                sum %= 1_000_000_009;
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}

package baekjoon.b17427;

import java.util.Scanner;

public class Main {

    private static final int MAX_VALUE = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[MAX_VALUE + 1];

        for (int i = 0; i < MAX_VALUE + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j < dp.length; j += i) {
                dp[j] += i;
            }
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[i];
        }

        System.out.println(sum);
    }
}

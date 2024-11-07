package baekjoon.b2445;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int space = 2 * N - i * 2;
            sb.append("*".repeat((2 * N - space) / 2))
                .append(" ".repeat(space))
                .append("*".repeat((2 * N - space) / 2));
            sb.append("\n");
        }
        for (int i = N - 1; i > 0; i--) {
            int space = 2 * N - i * 2;
            sb.append("*".repeat((2 * N - space) / 2))
                .append(" ".repeat(space))
                .append("*".repeat((2 * N - space) / 2))
                .append("\n");
        }
        System.out.println(sb);
    }
}

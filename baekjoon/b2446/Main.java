package baekjoon.b2446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i))
                .append("*".repeat((2 * N - 1) - (i * 2)))
                .append("\n");
        }
        for (int i = N - 2; i >= 0; i--) {
            sb.append(" ".repeat(i))
                .append("*".repeat((2 * N - 1) - (i * 2)));
            if (i != 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}

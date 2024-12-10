package baekjoon.b1748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        int limit = 10;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (i == limit) {
                limit *= 10;
                cnt++;
            }
            if (i < limit) {
                answer += cnt;
            }
        }
        System.out.print(answer);
    }
}

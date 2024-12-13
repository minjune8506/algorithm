package baekjoon.b6588;

import java.util.Scanner;

public class Main {
    static final int MAX_VALUE = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[MAX_VALUE];
        prime[0] = prime[1] = false;
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < MAX_VALUE; i++) {
            for (int j = i + i; j < MAX_VALUE; j += i) {
                prime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int number = sc.nextInt();
            if (number == 0) {
                break;
            }

            int x = 0;
            int y = 0;

            for (int i = 2; i <= number; i++) {
                if (prime[i] && prime[number - i]) {
                    x = i;
                    y = number - i;
                    break;
                }
            }
            if (x != 0 && y != 0) {
                sb.append(String.format("%d = %d + %d\n", number, x, y));
                continue;
            }
            sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.print(sb);
    }
}

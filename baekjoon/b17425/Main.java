package baekjoon.b17425;

import java.util.Scanner;

public class Main {

    private static final int MAX_VALUE = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        long[] map = new long[MAX_VALUE + 1];
        for (int i = 1; i <= MAX_VALUE; i++) {
            for (int j = 1; i * j <= MAX_VALUE; j++) {
                int key = i * j;
                map[key] += i;
            }
        }

        for (int i = 2; i <= MAX_VALUE; i++) {
            map[i] += map[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            int num = sc.nextInt();
            sb.append(map[num]).append('\n');
        }
        System.out.print(sb);
    }
}

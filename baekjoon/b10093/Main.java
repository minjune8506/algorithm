package baekjoon.b10093;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        // a > b 조건이 없음
        long start = Math.min(a, b);
        long end = Math.max(a, b);

        if (start == end) {
            System.out.println(0);
        } else {
            System.out.println(end - start - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (long i = start + 1; i < end; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

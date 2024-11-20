package baekjoon.b15988;

import java.util.Scanner;

/**
 * x - 1 나타내는 방법에 각각 +1
 * x - 2 나타내는 방법에 각각 +2
 * x - 3 나타내는 방법에 각각 +3
 */
public class Main {
    private static int MAX_VALUE = 1_000_000;
    private static int LIMIT = 1_000_000_009;

    public static void main(String[] args) {
        long[] ary = new long[MAX_VALUE + 1];
        ary[1] = 1;
        ary[2] = 2;
        ary[3] = 4;
        for (int i = 4; i <= MAX_VALUE; i++) {
            ary[i] = ary[i - 1] + ary[i - 2] + ary[i - 3];
            if (ary[i] > LIMIT) {
                ary[i] %= LIMIT;
            }
        }

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            sb.append(ary[sc.nextInt()])
                .append('\n');
        }
        System.out.print(sb);
    }
}

package baekjoon.b10811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void swap(int[] ary, int x, int y) {
        int tmp = ary[x];
        ary[x] = ary[y];
        ary[y] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] constraints = br.readLine().split(" ");
        int N = Integer.parseInt(constraints[0]);
        int M = Integer.parseInt(constraints[1]);

        int[] buckets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buckets[i] = i;
        }

        while (M-- > 0) {
            String[] positions = br.readLine().split(" ");
            int i = Integer.parseInt(positions[0]);
            int j = Integer.parseInt(positions[1]);

            for (int index = 0; index <= (j - i) / 2; index++) {
                swap(buckets, i + index, j - index);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= N ; i++) {
            sb.append(buckets[i] + " ");
        }
        System.out.println(sb);
    }
}

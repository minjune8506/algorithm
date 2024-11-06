package baekjoon.b10804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] ary = new int[21];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            for (int j = 0; j < (end - start + 1) / 2; j++) {
                int tmp = ary[start + j];
                ary[start + j] = ary[end - j];
                ary[end - j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ary.length; i++) {
            sb.append(ary[i]).append(" ");
        }
        System.out.println(sb);
    }
}

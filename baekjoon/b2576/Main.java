package baekjoon.b2576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 != 0) {
                sum += num;
                min = Math.min(num, min);
            }
        }
        if (sum <= 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}

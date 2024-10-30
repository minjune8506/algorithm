package baekjoon.b2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] inputs = br.readLine().split(" ");
            int[] numbers = new int[4];
            numbers[0] = Integer.parseInt(inputs[0]);
            numbers[1] = Integer.parseInt(inputs[1]);
            numbers[2] = Integer.parseInt(inputs[2]);
            numbers[3] = Integer.parseInt(inputs[3]);

            int cnt = 0;
            for (int number : numbers) {
                if (number == 0) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println('E');
                continue;
            }
            System.out.println((char)('A' + cnt - 1));
        }
    }
}

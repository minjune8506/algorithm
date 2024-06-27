package baekjoon.b2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] ary = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (int j = 0; j < numbers.length; j++) {
                ary[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int max = ary[0][0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (ary[i][j] > max) {
                    max = ary[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((x + 1) + " " + (y + 1));

    }
}

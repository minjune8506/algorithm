package baekjoon.b2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] paper = new int[101][101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            String[] lines = br.readLine().split(" ");
            int x = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);

            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    paper[i][j] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}

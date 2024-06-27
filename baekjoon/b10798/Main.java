package baekjoon.b10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] board = new String[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            board[i] = line;
            max = Math.max(line.length(), max);
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < max) {
            for (int i = 0; i < 5; i++) {
                if (board[i].length() > index) {
                    sb.append(board[i].charAt(index));
                }
            }
            index++;
        }
        System.out.println(sb);
    }
}

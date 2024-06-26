package baekjoon.b2444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int max = (N - 1) * 2 + 1;

        for (int i = 0; i < N; i++) {
            int count = i * 2 + 1;
            sb.append(" ".repeat((max - count) / 2));
            sb.append("*".repeat(count));
            sb.append(" \n");
        }

        for (int i = N - 2; i >= 0; i--) {
            int count = i * 2 + 1;
            sb.append(" ".repeat((max - count) / 2));
            sb.append("*".repeat(count));
            sb.append(" \n");
        }
        System.out.println(sb);
    }
}

package baekjoon.b1267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int y = 0;
        int m = 0;
        String[] times = br.readLine().split(" ");
        for (String time : times) {
            int t = Integer.parseInt(time);
            y += (t / 30 + 1) * 10;
            m += (t / 60 + 1) * 15;
        }
        if (y > m) {
            System.out.println("M " + m);
        } else if (y < m) {
            System.out.println("Y " + y);
        } else {
            System.out.println("Y M " + m);
        }
    }
}

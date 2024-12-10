package baekjoon.b1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ex = 1;
        int sx = 1;
        int mx = 1;
        int cnt = 1;
        while (ex != e || sx != s || mx != m) {
            ex++;
            sx++;
            mx++;
            if (ex % 16 == 0) {
                ex = 1;
            }
            if (sx % 29 == 0) {
                sx = 1;
            }
            if (mx % 20 == 0) {
                mx = 1;
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}

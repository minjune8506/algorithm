package baekjoon.b15664;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] ary;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n];
        picked = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        sb = new StringBuilder();
        pick(0, 0);
        System.out.print(sb);
    }

    static void pick(int cnt, int idx) {
        int num = 0;
        if (cnt == m) {
            for (int pick : picked) {
                sb.append(pick + " ");
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i < ary.length; i++) {
            if (!visited[i]) {
                if (num == ary[i]) {
                    continue;
                }
                visited[i] = true;
                picked[cnt] = ary[i];
                pick(cnt + 1, i + 1);
                visited[i] = false;
                num = ary[i];
            }
        }
    }
}

package baekjoon.b15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static StringBuilder sb;
    static int[] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        sb = new StringBuilder();
        dfs(new boolean[n], new int[m], 0, 0);
        System.out.println(sb);
    }

    private static void dfs(boolean[] visited, int[] picked, int cnt, int idx) {
        if (cnt == m) {
            for (int pick : picked) {
                sb.append(pick).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[cnt] = ary[i];
                dfs(visited, picked, cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

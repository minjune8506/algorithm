package baekjoon.b13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            if (dfs(graph, visited, i, 1)) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }

    private static boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int i, int cnt) {
        if (cnt == 5) {
            return true;
        }

        for (int friend : graph[i]) {
            if (!visited[friend]) {
                visited[friend] = true;
                if (dfs(graph, visited, friend, cnt + 1)) {
                    return true;
                }
                visited[friend] = false;
            }
        }
        return false;
    }
}

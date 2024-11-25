package baekjoon.b1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 1;
    private static final int BLUE = 2;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            if (solve()) {
                sb.append("YES\n");
                continue;
            }
            sb.append("NO\n");
        }
        System.out.print(sb);
    }

    private static boolean solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int[] visited = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                visited[i] = RED;
                if (!dfs(graph, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int[] visited, int start) {
        ArrayList<Integer> nodes = graph[start];
        int color = visited[start];
        for (int node : nodes) {
            if (color == visited[node]) {
                return false;
            }
            if (visited[node] == 0) {
                visited[node] = color == RED ? BLUE : RED;
                if (!dfs(graph, visited, node)) {
                    return false;
                }
            }
        }
        return true;
    }
}

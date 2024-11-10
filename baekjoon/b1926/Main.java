package baekjoon.b1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");
        int n = Integer.parseInt(mapInfo[0]);
        int m = Integer.parseInt(mapInfo[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(lines[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    cnt++;
                    sum = Math.max(dfs(map, visited, n, m, i, j, 0), sum);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sum);
    }

    private static int dfs(int[][] map, boolean[][] visited, int n, int m, int y, int x, int area) {
        visited[y][x] = true;
        area++;

        if (x + 1 < m && !visited[y][x + 1] && map[y][x + 1] != 0) {
            area = dfs(map, visited, n, m, y, x + 1, area);
        }
        if (x - 1 >= 0 && !visited[y][x - 1] && map[y][x - 1] != 0) {
            area = dfs(map, visited, n, m, y, x - 1, area);
        }
        if (y + 1 < n && !visited[y + 1][x] && map[y + 1][x] != 0) {
            area = dfs(map, visited, n, m, y + 1, x, area);
        }
        if (y - 1 >= 0 && !visited[y - 1][x] && map[y - 1][x] != 0) {
            area = dfs(map, visited, n, m, y - 1, x, area);
        }
        return area;
    }
}

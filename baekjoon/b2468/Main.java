package baekjoon.b2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];

        int max = 0;
        for (int i = 0; i < size; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(lines[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 0;
        for (int limit = 0; limit <= max; limit++) {
            boolean[][] visited = new boolean[size][size];
            int cnt = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visited[i][j] && map[i][j] > limit) {
                        dfs(map, limit, visited, i, j, size);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    private static void dfs(int[][] map, int limit, boolean[][] visited, int y, int x, int size) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < size && ny < size && map[ny][nx] > limit && !visited[ny][nx]) {
                dfs(map, limit, visited, ny, nx, size);
            }
        }
    }
}

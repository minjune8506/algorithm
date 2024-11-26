package baekjoon.b18290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int width;
    private static int height;
    private static int pick;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        pick = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MIN_VALUE;
        solve(map, visited, 0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void solve(int[][] map, boolean[][] visited, int y, int x, int sum, int cnt) {
        if (cnt == pick) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = y; i < height; i++) {
            for (int j = (i == y ? x : 0); j < width; j++) {
                // 다음 row 로 넘어가지 않았으면 x 유지 아니면 0부터..
                if (!visited[i][j] && check(visited, i, j)) {
                    visited[i][j] = true;
                    solve(map, visited, i, j, sum + map[i][j], cnt + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static boolean check(boolean[][] visited, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                if (visited[ny][nx]) {
                    return false;
                }
            }
        }
        return true;
    }
}

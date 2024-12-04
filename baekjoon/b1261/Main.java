package baekjoon.b1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Comparator<int[]> comparator = (x, y) -> x[2] - y[2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        boolean[][] visited = new boolean[height][width];
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] first = queue.remove();
            int x = first[0];
            int y = first[1];
            int cnt = first[2];

            if (x == width - 1 && y == height - 1) {
                System.out.print(cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= width || ny >= height || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                if (map[ny][nx] == 0) {
                    queue.add(new int[]{nx, ny, cnt});
                } else {
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
    }
}

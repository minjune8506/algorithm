package baekjoon.b7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[n][n];

            String[] positions = br.readLine().split(" ");
            int nowY = Integer.parseInt(positions[0]);
            int nowX = Integer.parseInt(positions[1]);

            String[] destinations = br.readLine().split(" ");
            int destY = Integer.parseInt(destinations[0]);
            int destX = Integer.parseInt(destinations[1]);

            System.out.println(bfs(nowX, nowY, destX, destY, n, visited));
        }
    }

    static int bfs(int nowX, int nowY, int destX, int destY, int n, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        visited[nowY][nowX] = true;
        queue.add(new Position(nowY, nowX, 0));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.x == destX && pos.y == destY) {
                return pos.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int newY = pos.y + dy[i];
                int newX = pos.x + dx[i];
                if (newY < n && newX < n && newY >= 0 && newX >= 0 && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.add(new Position(newY, newX, pos.cnt + 1));
                }
            }

        }
        return -1;
    }

    static class Position {
        int y;
        int x;
        int cnt;

        public Position(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}

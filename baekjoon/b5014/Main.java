package baekjoon.b5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int height = Integer.parseInt(inputs[0]);
        int current = Integer.parseInt(inputs[1]);
        int target = Integer.parseInt(inputs[2]);
        int up = Integer.parseInt(inputs[3]);
        int down = Integer.parseInt(inputs[4]);

        int answer = bfs(height, target, current, up, down);
        if (answer < 0) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(answer);
    }

    static int bfs(int height, int target, int current, int up, int down) {
        boolean[] visited = new boolean[height + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{current, 0});
        visited[current] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.remove();
            int pos = front[0];
            int cnt = front[1];

            if (pos == target) {
                return cnt;
            }

            int newCur = pos + up;
            if (height >= newCur && !visited[newCur]) {
                visited[newCur] = true;
                queue.add(new int[]{newCur, cnt + 1});
            }

            newCur = pos - down;
            if (newCur > 0 && !visited[newCur]) {
                visited[newCur] = true;
                queue.add(new int[]{newCur, cnt + 1});
            }
        }
        return -1;
    }
}

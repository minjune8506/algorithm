package baekjoon.b13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int MAX_VALUE = 110_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);


        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_VALUE];

        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] first = queue.remove();
            int pos = first[0];
            int cnt = first[1];

            if (pos == k) {
                System.out.println(cnt);
                return;
            }

            int nextPos = pos * 2;
            if (nextPos < MAX_VALUE && !visited[nextPos]) {
                visited[nextPos] = true;
                queue.add(new int[]{nextPos, cnt});
            }

            nextPos = pos - 1;
            if (nextPos >= 0 && !visited[nextPos]) {
                visited[nextPos] = true;
                queue.add(new int[]{nextPos, cnt + 1});
            }

            nextPos = pos + 1;
            if (nextPos < MAX_VALUE && !visited[nextPos]) {
                visited[nextPos] = true;
                queue.add(new int[]{nextPos, cnt + 1});
            }
        }
    }
}

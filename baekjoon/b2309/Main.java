package baekjoon.b2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;
        }
        Arrays.sort(heights);
        boolean[] visited = new boolean[heights.length];
        dfs(heights, visited, 0, 0);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.println(heights[i]);
            }
        }
    }

    private static boolean dfs(int[] heights, boolean[] visited, int sum, int cnt) {
        if (cnt == 7 && sum == 100) {
            return true;
        }

        for (int i = 0; i < heights.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(heights, visited, sum + heights[i], cnt + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}

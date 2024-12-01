package baekjoon.b13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pos = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);

        int[] visited = new int[MAX_VALUE];
        for (int i = 0; i < MAX_VALUE; i++) {
            visited[i] = -1;
        }
        visited[pos] = pos;

        while (!queue.isEmpty()) {
            int first = queue.remove();
            if (first == target) {
                ArrayList<Integer> result = new ArrayList<>();
                while (first != pos) {
                    result.add(first);
                    first = visited[first];
                }
                result.add(pos);

                StringBuilder sb = new StringBuilder();
                sb.append(result.size() - 1).append('\n');
                for (int i = result.size() - 1; i >= 0; i--) {
                    sb.append(result.get(i)).append(' ');
                }
                System.out.println(sb);
                return;
            }

            if (first + 1 < MAX_VALUE && visited[first + 1] < 0) {
                visited[first + 1] = first;
                queue.add(first + 1);
            }
            if (first - 1 >= 0 && visited[first - 1] < 0) {
                visited[first - 1] = first;
                queue.add(first - 1);
            }
            if (first * 2 < MAX_VALUE && visited[first * 2] < 0) {
                visited[first * 2] = first;
                queue.add(first * 2);
            }
        }
    }
}

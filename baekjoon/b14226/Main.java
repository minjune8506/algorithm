package baekjoon.b14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int MAX_VALUE = 2000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0});

        boolean[][] visited = new boolean[MAX_VALUE][MAX_VALUE];
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] first = queue.remove();
            int emoji = first[0];
            int clipboard = first[1];
            int cnt = first[2];

            if (emoji == target) {
                System.out.print(cnt);
                return;
            }

            // 붙여넣기
            if (emoji + clipboard < MAX_VALUE && clipboard > 0 && !visited[emoji + clipboard][clipboard]) {
                visited[emoji + clipboard][clipboard] = true;
                queue.add(new int[]{emoji + clipboard, clipboard, cnt + 1});
            }

            // 삭제
            if (emoji - 1 >= 0 && !visited[emoji - 1][clipboard]) {
                visited[emoji - 1][clipboard] = true;
                queue.add(new int[]{emoji - 1, clipboard, cnt + 1});
            }

            // 복사
            if (clipboard != emoji) {
                queue.add(new int[]{emoji, emoji, cnt + 1});
            }
        }
    }
}

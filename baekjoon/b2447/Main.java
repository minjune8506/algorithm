package baekjoon.b2447;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] ary = new char[n][n];
        drawStar(ary, 0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ary[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


    private static void drawStar(char[][] ary, int x, int y, int n, boolean blank) {
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    ary[i][j] = ' ';
                }
            }
            return;
        }

        if (n <= 1) {
            ary[x][y] = '*';
            return;
        }

        int star = 0;
        for (int i = x; i < x + n; i += n / 3) {
            for (int j = y; j < y + n; j += n / 3) {
                star++;
                if (star == 5) {
                    drawStar(ary, i, j, n / 3, true);
                } else {
                    drawStar(ary, i, j, n / 3, false);
                }
            }
        }

    }
}

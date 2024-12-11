package baekjoon.b3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(map, i, j, i, j + 1);
                max = Math.max(count(map), max);
                swap(map, i, j + 1, i, j);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(map, i, j, i + 1, j);
                max = Math.max(count(map), max);
                swap(map, i + 1, j, i, j);
            }
        }

        System.out.print(max);
    }

    static void swap(char[][] map, int x1, int y1, int x2, int y2) {
        char tmp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = tmp;
    }

    static int count(char[][] map) {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                char color = map[i][j];
                max = Math.max(max, Math.max(countRow(map, color, i, j), countColumn(map, color, i, j)));
            }
        }
        return max;
    }

    static int countRow(char[][] map, char color, int i, int j) {
        int cntRight = 0;
        for (int x = j + 1; x < map[i].length; x++) {
            if (color != map[i][x]) {
                break;
            }
            cntRight++;
        }
        int cntLeft = 0;
        for (int x = j - 1; x >= 0; x--) {
            if (color != map[i][x]) {
                break;
            }
            cntLeft++;
        }
        return cntRight + cntLeft + 1;
    }

    static int countColumn(char[][] map, char color, int i, int j) {
        int cntUp = 0;
        for (int y = i + 1; y < map.length; y++) {
            if (color != map[y][j]) {
                break;
            }
            cntUp++;
        }
        int cntDown = 0;
        for (int y = i - 1; y >= 0; y--) {
            if (color != map[y][j]) {
                break;
            }
            cntDown++;
        }
        return cntUp + cntDown + 1;
    }
}

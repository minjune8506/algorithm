package baekjoon.b16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int operations = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (operations-- > 0) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    upsideDown(map, height, width);
                    break;
                case 2:
                    leftRightInversion(map, height, width);
                    break;
                case 3:
                    map = rotateRight(map, height, width);
                    break;
                case 4:
                    map = rotateLeft(map, height, width);
                    break;
                case 5:
                    map = rotateQuarterRight(map, height, width);
                    break;
                case 6:
                    map = rotateQuarterLeft(map, height, width);
                    break;
            }
            if (command == 3 || command == 4) {
                int tmp = width;
                width = height;
                height = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void upsideDown(int[][] map, int height, int width) {
        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width; j++) {
                int tmp = map[i][j];
                map[i][j] = map[height - 1 - i][j];
                map[height - 1 - i][j] = tmp;
            }
        }
    }

    private static void leftRightInversion(int[][] map, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width / 2; j++) {
                int tmp = map[i][j];
                map[i][j] = map[i][width - 1 - j];
                map[i][width - 1 - j] = tmp;
            }
        }
    }

    private static int[][] rotateRight(int[][] map, int height, int width) {
        int[][] newMap = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = height - 1; j >= 0; j--) {
                newMap[i][height - 1 - j] = map[j][i];
            }
        }

        return newMap;
    }

    private static int[][] rotateLeft(int[][] map, int height, int width) {
        int[][] newMap = new int[width][height];
        for (int i = width - 1; i >= 0; i--) {
            for (int j = 0; j < height; j++) {
                newMap[width - 1 - i][j] = map[j][i];
            }
        }
        return newMap;
    }

    private static int[][] rotateQuarterRight(int[][] map, int height, int width) {
        int[][] newMap = new int[height][width];
        int y;
        int x;

        y = 0;
        for (int i = height / 2; i < height; i++) {
            x = 0;
            for (int j = 0; j < width / 2; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = 0;
        for (int i = 0; i < height / 2; i++) {
            x = width / 2;
            for (int j = 0; j < width / 2; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = height / 2;
        for (int i = height / 2; i < height; i++) {
            x = 0;
            for (int j = width / 2; j < width; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = height / 2;
        for (int i = 0; i < height / 2; i++) {
            x = width / 2;
            for (int j = width / 2; j < width; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }
        return newMap;
    }

    private static int[][] rotateQuarterLeft(int[][] map, int height, int width) {
        int[][] newMap = new int[height][width];
        int y;
        int x;

        y = 0;
        for (int i = 0; i < height / 2; i++) {
            x = 0;
            for (int j = width / 2; j < width; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = 0;
        for (int i = height / 2; i < height; i++) {
            x = width / 2;
            for (int j = width / 2; j < width; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = height / 2;
        for (int i = 0; i < height / 2; i++) {
            x = 0;
            for (int j = 0; j < width / 2; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }

        y = height / 2;
        for (int i = height / 2; i < height; i++) {
            x = width / 2;
            for (int j = 0; j < width / 2; j++) {
                newMap[y][x++] = map[i][j];
            }
            y++;
        }
        return newMap;
    }
}

package baekjoon.b3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[size];
        for (int i = 0; i < size; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(ary);

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (ary[i] > target) {
                break;
            }
            for (int j = i + 1; j < size; j++) {
                if (ary[i] + ary[j] == target) {
                    cnt++;
                }
                if (ary[i] + ary[j] > target) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}

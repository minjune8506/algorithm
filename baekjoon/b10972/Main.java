package baekjoon.b10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 이해 잘 안감
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        int idx = 0;
        while (st.hasMoreTokens()) {
            numbers[idx++] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (hasNextPermutation(numbers)) {
            for (int number : numbers) {
                sb.append(number).append(' ');
            }
            System.out.print(sb);
            return;
        }
        System.out.print(-1);
    }

    private static boolean hasNextPermutation(int[] numbers) {
        int i = numbers.length - 1;

        // 순열에서 내림차순이 시작되는 위치를 찾는다.
        while (i > 0 && numbers[i - 1] > numbers[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = numbers.length - 1;
        while (numbers[j] <= numbers[i - 1]) {
            j--;
        }

        int tmp = numbers[i - 1];
        numbers[i - 1] = numbers[j];
        numbers[j] = tmp;

        Arrays.sort(numbers, i, numbers.length);
        return true;
    }
}

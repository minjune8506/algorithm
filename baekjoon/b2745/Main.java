package baekjoon.b2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        String str = numbers[0];
        int digit = Integer.parseInt(numbers[1]);

        int sum = 0;
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int n;
            if (c >= 'A' && c <= 'Z') {
                n = c - 'A' + 10;
            } else {
                n = c - '0';
            }
            sum += (int) (n * Math.pow(digit, index));
            index++;
        }
        System.out.println(sum);
    }
}

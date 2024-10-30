package baekjoon.b1475;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        int[] numbers = new int[10];
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '6' || c == '9') {
                numbers[6]++;
                continue;
            }
            numbers[c - '0']++;
        }

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 6) {
                continue;
            }
            max = Math.max(max, numbers[i]);
        }

        int six = numbers[6] / 2 + numbers[6] % 2;
        max = Math.max(max, six);
        System.out.println(max);
    }
}

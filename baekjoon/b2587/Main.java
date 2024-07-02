package baekjoon.b2587;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] ary = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            ary[i] = sc.nextInt();
        }

        Arrays.sort(ary);
        int sum = Arrays.stream(ary).sum();
        System.out.println(sum / 5);
        System.out.println(ary[2]);

    }

}

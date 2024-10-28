package baekjoon.b10808;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] alphabets = new int[26];
        for (int i = 0; i < word.length(); i++) {
            alphabets[(word.charAt(i) - 'a')]++;
        }
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i] + " ");
        }
    }
}

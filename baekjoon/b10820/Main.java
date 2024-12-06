package baekjoon.b10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            int lowerCase = 0;
            int upperCase = 0;
            int number = 0;
            int space = 0;

            for (char c : str.toCharArray()) {
                if (c == ' ') {
                    space++;
                }
                if (Character.isDigit(c)) {
                    number++;
                }
                if (Character.isLowerCase(c)) {
                    lowerCase++;
                }
                if (Character.isUpperCase(c)) {
                    upperCase++;
                }
            }
            System.out.println(String.format("%d %d %d %d", lowerCase, upperCase, number, space));
        }
    }
}

package baekjoon.b1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        int index = 0;
        while (index < document.length()) {
            int found = document.indexOf(word, index);
            if (found < 0) {
                break;
            }
            index = found + word.length();
            cnt++;
        }
        System.out.println(cnt);
    }
}

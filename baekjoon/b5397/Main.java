package baekjoon.b5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String input = br.readLine();
            int cursor = 0;
            List<Character> password = new LinkedList<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '<':
                        cursor = Math.max(cursor - 1, 0);
                        break;
                    case '>':
                        cursor = Math.min(cursor + 1, password.size());
                        break;
                    case '-':
                        if (cursor > 0) {
                            password.remove(--cursor);
                        }
                        break;
                    default:
                        password.add(cursor, c);
                        cursor++;
                        break;
                }
            }
            for (Character c : password) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
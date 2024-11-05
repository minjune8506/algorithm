package baekjoon.b9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String parenthesis = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean success = true;
            for (int i = 0; i < parenthesis.length(); i++) {
                char c = parenthesis.charAt(i);

                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        success = false;
                        break;
                    }
                } else {
                    stack.push(c);
                }
            }

            if (success && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

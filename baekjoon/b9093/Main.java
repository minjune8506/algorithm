package baekjoon.b9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                for (Character c : token.toCharArray()) {
                    stack.push(c);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

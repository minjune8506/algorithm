package baekjoon.b17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean tag = false;
        String sentence = sc.nextLine();
        for (Character c : sentence.toCharArray()) {
            if (c == '<' || c == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            if (c == '<' || c == '>') {
                tag = !tag;
                sb.append(c);
                continue;
            }
            if (tag) {
                sb.append(c);
                continue;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

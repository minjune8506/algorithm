package baekjoon.b10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 다섯 가지이다.
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class Main {

    private static int[] stack;
    private static int size = 0;
    private static final StringBuilder sb = new StringBuilder();

    enum Command {
        PUSH,
        POP,
        SIZE,
        EMPTY,
        TOP
    }

    public static void push(int item) {
        stack[size++] = item;
    }

    public static int pop() {
        if (empty()) {
            return -1;
        }
        return stack[--size];
    }

    public static int size() {
        return size;
    }

    public static boolean empty() {
        return size <= 0;
    }

    public static int top() {
        if (empty()) {
            return -1;
        }
        return stack[size - 1];
    }

    public static void run(String input) {
        String[] tokens = input.split(" ");
        Command command = Command.valueOf(tokens[0].toUpperCase());
        switch (command) {
            case PUSH:
                push(Integer.parseInt(tokens[1]));
                break;
            case POP:
                sb.append(pop()).append('\n');
                break;
            case SIZE:
                sb.append(size()).append('\n');
                break;
            case EMPTY:
                sb.append(empty() ? "1" : "0").append('\n');
                break;
            case TOP:
                sb.append(top()).append('\n');
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        while (N-- > 0) {
            run(br.readLine());
        }

        System.out.println(sb);
    }
}

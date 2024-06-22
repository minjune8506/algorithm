package baekjoon.b10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 여섯 가지이다.
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * </p>
 */

public class Main {
    private static ArrayList<Integer> lst = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String command = br.readLine();
            String[] commands = command.split(" ");
            run(commands);
        }
        System.out.println(sb);
    }

    private static void run(String[] commands) {
        COMMAND command = COMMAND.valueOf(commands[0].toUpperCase());
        switch (command) {
            case PUSH:
                push(Integer.parseInt(commands[1]));
                break;
            case POP:
                sb.append(pop()).append("\n");
                break;
            case SIZE:
                sb.append(size()).append("\n");
                break;
            case BACK:
                sb.append(back()).append("\n");
                break;
            case FRONT:
                sb.append(front()).append("\n");
                break;
            case EMPTY:
                sb.append(empty() ? "1" : "0").append("\n");
                break;
        }
    }

    private static void push(int item) {
        lst.add(item);
    }

    private static int pop() {
        if (empty()) {
            return -1;
        }
        return lst.remove(0);
    }

    private static int size() {
        return lst.size();
    }

    private static boolean empty() {
        return lst.isEmpty();
    }

    private static int front() {
        if (empty()) {
            return -1;
        }
        return lst.get(0);
    }

    private static int back() {
        if (empty()) {
            return -1;
        }
        return lst.get(lst.size() - 1);
    }

    private enum COMMAND {
        PUSH,
        POP,
        SIZE,
        EMPTY,
        FRONT,
        BACK
    }
}

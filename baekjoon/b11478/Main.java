package baekjoon.b11478;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<String> set;

    public static void main(String[] args) {
        set = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        pick(str, 1);

        System.out.println(set.size());
    }

    private static void pick(String str, int depth) {
        if (str.length() < depth) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (i + depth <= str.length()) {
                set.add(str.substring(i, i + depth));
            }
        }
        pick(str, depth + 1);
    }
}

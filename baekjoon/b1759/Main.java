package baekjoon.b1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final List<String> vowels = List.of("a", "e", "i", "o", "u");
    private static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int type = Integer.parseInt(st.nextToken());

        String[] alphabets = new String[type];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < type; i++) {
            alphabets[i] = st.nextToken();
        }
        sb = new StringBuilder();
        Arrays.sort(alphabets);
        makePassword(alphabets, "", length, 0, 0, 0);
        System.out.print(sb);
    }

    public static void makePassword(String[] alphabets, String password, int length, int idx, int vowelCnt, int consonantCnt) {
        if (password.length() == length) {
            if (vowelCnt > 0 && consonantCnt > 1) {
                sb.append(password).append('\n');
            }
            return;
        }
        for (int i = idx; i < alphabets.length; i++) {
            if (vowels.contains(alphabets[i])) {
                makePassword(alphabets, password + alphabets[i], length, i + 1, vowelCnt + 1, consonantCnt);
                continue;
            }
            makePassword(alphabets, password + alphabets[i], length, i + 1, vowelCnt, consonantCnt + 1);
        }
    }
}

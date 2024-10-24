package baekjoon.b13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] limits = br.readLine().split(" ");
        int maxStudents = Integer.parseInt(limits[0]);
        int count = Integer.parseInt(limits[1]);

        Map<String, Integer> m = new HashMap<>();
        // 학번 / 순위 데이터 저장
        // 들어온 순서대로 낮은 순위 부여
        // 중복해서 신청할 경우 순위 초기화
        int rank = 0;
        while (count-- > 0) {
            String studentNo = br.readLine();
            m.put(studentNo, rank++);
        }

        StringBuilder sb = new StringBuilder();
        // 순위가 낮은 순으로 정렬하여 수강신청
        m.entrySet().stream()
            .sorted(Comparator.comparingInt(Entry::getValue))
            .limit(maxStudents)
            .forEach(entry -> sb.append(entry.getKey() + "\n"));
        System.out.print(sb);
    }
}

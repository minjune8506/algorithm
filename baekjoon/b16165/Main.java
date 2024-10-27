package baekjoon.b16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int total = Integer.parseInt(inputs[0]);
        int questions = Integer.parseInt(inputs[1]);

        Map<String, List<String>> girlGroups = new HashMap<>();
        while (total-- > 0) {
            String teamName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            while (memberCount-- > 0) {
                members.add(br.readLine());
            }
            members.sort(Comparator.naturalOrder());
            girlGroups.put(teamName, members);
        }

        StringBuilder sb = new StringBuilder();
        while (questions-- > 0) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                girlGroups.get(question).forEach(s -> sb.append(s).append("\n"));
            } else {
                for (Entry<String, List<String>> entry : girlGroups.entrySet()) {
                    if (entry.getValue().contains(question)) {
                        sb.append(entry.getKey()).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }
}

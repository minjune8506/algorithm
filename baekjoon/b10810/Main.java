package baekjoon.b10810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] constraints = br.readLine().split(" ");
        int N = Integer.parseInt(constraints[0]);
        int M = Integer.parseInt(constraints[1]);

        int[] buckets = new int[N];

        while (M-- > 0) {
            String[] line = br.readLine().split(" ");
            int i = Integer.parseInt(line[0]);
            int j = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);

            for (int index = i; index <= j; index++) {
                buckets[index - 1] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int bucket : buckets) {
            sb.append(bucket + " ");
        }
        System.out.println(sb);
    }
}


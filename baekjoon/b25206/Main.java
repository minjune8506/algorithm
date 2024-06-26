package baekjoon.b25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    private static double[] points = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double grdaeSum = 0;
        int subjects = 20;
        while (subjects-- > 0) {
            String[] grade = br.readLine().split(" ");

            for (int i = 0; i < grades.length; i++) {
                if (grades[i].equals(grade[2])) {
                    sum += Double.parseDouble(grade[1]) * points[i];
                    grdaeSum += Double.parseDouble(grade[1]);
                }
            }
        }
        System.out.println(sum / grdaeSum);
    }
}

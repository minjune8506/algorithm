package baekjoon.b13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int students = Integer.parseInt(inputs[0]);
        int roomCapacity = Integer.parseInt(inputs[1]);

        Map<Student, Integer> m = new HashMap<>();
        while (students-- > 0) {
            String[] studentInfo = br.readLine().split(" ");
            int sex = Integer.parseInt(studentInfo[0]);
            int grade = Integer.parseInt(studentInfo[1]);
            Student student = new Student(sex, grade);
            m.put(student, m.getOrDefault(student, 0) + 1);
        }

        int answer = 0;
        for (Map.Entry<Student, Integer> entry : m.entrySet()) {
            int count = entry.getValue();
            answer += (count / roomCapacity + (count % roomCapacity > 0 ? 1 : 0));
        }
        System.out.println(answer);
    }

    private static class Student {
        int sex;
        int grade;

        public Student(int sex, int grade) {
            this.sex = sex;
            this.grade = grade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return sex == student.sex && grade == student.grade;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sex, grade);
        }
    }
}

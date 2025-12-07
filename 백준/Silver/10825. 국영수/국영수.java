import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        String name;
        int korean;
        int english;
        int math;

        public Person(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Person(name, korean, english, math));
        }

        list.sort((o1, o2)-> {
            if (o1.korean != o2.korean) { // 국어 점수가 다르면 감소하는 순 (내림차)
                return Integer.compare(o2.korean, o1.korean);
            }
            if (o1.english != o2.english) { // 영어 점수가 다르면 증가하는 순 (오름차)
                return Integer.compare(o1.english, o2.english);
            }
            if (o1.math != o2.math) { // 수학 내림차
                return Integer.compare(o2.math, o1.math);
            }
            return o1.name.compareTo(o2.name);
        });

        for (Person person : list) {
            sb.append(person.name).append("\n");
        }

        System.out.println(sb);
    }
}

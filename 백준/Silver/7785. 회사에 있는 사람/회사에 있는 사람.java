import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String behave = st.nextToken();

            if (Objects.equals(behave, "enter")) {
                set.add(name);
            } else if (Objects.equals(behave, "leave")) {
                set.remove(name);
            }
        }

        List<String> nameList = new LinkedList<>(set);
        nameList.sort(Collections.reverseOrder());

        for (String string : nameList) {
            sb.append(string).append('\n');
        }
        System.out.println(sb);
    }
}

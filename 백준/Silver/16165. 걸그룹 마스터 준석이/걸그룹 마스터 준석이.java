import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, List<String>> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Group
        for (int i = 0; i < n; i++) {
            String group = br.readLine(); // 그룹 이름
            int count = Integer.parseInt(br.readLine()); // 멤버 수

            List<String> memberList = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                String memberName = br.readLine();
                memberList.add(memberName);
            }
            map.put(group, memberList);
        }

        StringBuilder sb = new StringBuilder();

        // Quiz
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int member = Integer.parseInt(br.readLine());

            if (member == 1) {
                for (String group : map.keySet()) {
                    if (map.get(group).contains(name)) {
                        sb.append(group).append("\n");
                    }
                }
            } else {
                List<String> list = map.get(name);

                Collections.sort(list);
                for (String memberName : list) {
                    sb.append(memberName).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

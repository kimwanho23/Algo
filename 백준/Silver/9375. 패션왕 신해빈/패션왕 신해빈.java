import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < test; i++) {
            int N = Integer.parseInt(br.readLine()); //해빈이의 의상 수

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상의 이름
                String type = st.nextToken(); // 의상의 종류

                map.put(type, map.getOrDefault(type, 0) + 1);
            }
                int ans  = 1;
                for (int val : map.values())
                    ans *= val + 1;
                sb.append(ans - 1).append("\n");
        }
        System.out.println(sb);
    }
}

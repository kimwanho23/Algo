import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         // 이중 우선순위 큐 Q
        // I n : 정수 n을 Q에 삽입함.
        // D 1: Q에서 최댓값을 삭제함
        // D -1 :Q에서 최솟값을 삭제함

        TreeMap<Integer, Integer> map;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine()); // Q에 적용할 연산의 개수

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (s.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (s.equals("D")){
                    if (map.isEmpty()) continue;

                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }
            if (!map.isEmpty()) {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            } else {
                sb.append("EMPTY").append('\n');
            }
        }
        System.out.println(sb);
    }
}

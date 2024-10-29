import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int j = 0; j < T; j++) {

            String p = br.readLine(); // 함수 p
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수 n

            Deque<Integer> deque = new ArrayDeque<>(); // deque 생성

            st = new StringTokenizer(br.readLine(), "[],");

            for(int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(p, deque);

        }
        System.out.println(sb);
    }

    static void AC(String command, Deque<Integer> deque){
        boolean isRight = true; // 방향 상태 변수 True 정위치, False 역방향

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
            } else if (cmd == 'D') {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (isRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(isRight ? deque.pollFirst() : deque.pollLast());
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]\n");
    }
}

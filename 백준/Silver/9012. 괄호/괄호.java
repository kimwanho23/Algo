import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스


        for (int t = 0; t < T; t++) {
            Deque<Character> q = new ArrayDeque<>();
            String s = br.readLine();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '('){
                    q.push(s.charAt(i));
                } else {
                    if (q.isEmpty() || q.peekFirst() == ')'){
                        flag = false;
                        break;
                    }
                    q.pop();
                }
            }

            if (flag && q.isEmpty()){
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

            // 스택이 비었을 경우 YES 출력
        }
        System.out.println(sb);
    }
}

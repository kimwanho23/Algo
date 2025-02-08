import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 명령의 수

        StringTokenizer st;

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if (Objects.equals(s, PUSH)){
                q.offer(Integer.parseInt(st.nextToken()));
            } else if (Objects.equals(s, POP)){
                if (!q.isEmpty()){
                    sb.append(q.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (Objects.equals(s, SIZE)){
                sb.append(q.size()).append("\n");
            } else if (Objects.equals(s, EMPTY)){
                if (q.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (Objects.equals(s, FRONT)){
                if (!q.isEmpty()){
                    sb.append(q.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (Objects.equals(s, BACK)){
                if (!q.isEmpty()){
                    sb.append(q.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

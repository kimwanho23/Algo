import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; // 자료구조의 종류
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); // 자료구조의 개수 N
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        // 둘째 줄, 길이 N의 수열 A
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        // 셋째 줄M 길이 N의 수열 B
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (arr[i] == 0){
                deque.push(current);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 수열의 길이 M

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}

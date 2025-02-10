import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] arr;
    static int N, S, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 수열의 합

        visited = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);

        System.out.println(S == 0 ? answer - 1 : answer);
    }

    static void DFS(int depth, int sum){
        if (depth == N){
            if (sum == S) answer++;
            return;
        }

        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}

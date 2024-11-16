import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num, arr;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 숫자 개수
        M = Integer.parseInt(st.nextToken()); // depth

        num = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        DFS(0, 0);
        System.out.println(sb);
    }
    static void DFS(int start, int depth){
        if (depth == M){
            for (int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                arr[depth] = num[i];
                DFS(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}

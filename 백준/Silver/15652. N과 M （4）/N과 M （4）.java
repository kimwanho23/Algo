import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1~N 까지의 자연수
        M = Integer.parseInt(st.nextToken()); // M개를 고른 수열

        arr = new int[M];

        DFS(1 ,0);
        System.out.println(sb);
    }

    static void DFS(int node, int depth){
        if (depth == M){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = node; i <= N; i++) {
            arr[depth] = i;
            DFS(i, depth + 1);
        }
    }
}

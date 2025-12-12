import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N, M, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열
        }

        combination(0,0, 0);
        System.out.println(max);
    }
    public static void combination(int start, int current, int depth) {
        if (depth == 3) {
            if (current <= M && max < current) { // 현재가 m을 넘지 않으며, 기존값보다 클 때
                max = current;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, current + arr[i], depth + 1);
            visited[i] = false;
        }
    }
}

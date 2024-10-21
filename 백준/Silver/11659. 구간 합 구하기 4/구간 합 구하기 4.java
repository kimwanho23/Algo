import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

        arr = new int[N + 1];
        result = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        arr[0] = 0;
        result[0] = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            result[i] = arr[i] + result[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int total = result[end] - result[start - 1];
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int current = 0, min = Integer.MAX_VALUE;

        while (end < N) {
            while (end < N && current < S) {
                current += arr[end++];
            }
            while (current >= S) {
                min = Math.min(min, end - start);
                current -= arr[start++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}

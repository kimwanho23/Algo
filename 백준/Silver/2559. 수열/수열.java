import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max, sum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 숫자 
        int K = Integer.parseInt(st.nextToken()); // 일 수

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        max = sum;

        for (int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[i - K];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

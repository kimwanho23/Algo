import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            // 수는 절댓값이 1,000보다 작거나 같은 정수
            // 수는 중복되지 않는다.
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}

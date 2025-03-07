import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] cur, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        cur = new int[N + 1];  // 1-based index 사용
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cur[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cur[1];
        if (N > 1) {
            dp[2] = cur[1] + cur[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + cur[i], dp[i - 3] + cur[i - 1] + cur[i]));

        }

        System.out.println(dp[N]);
    }
}

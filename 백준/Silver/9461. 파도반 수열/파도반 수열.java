import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        // 초기 5개 값

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int n = Integer.parseInt(br.readLine()); // P(n)
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}

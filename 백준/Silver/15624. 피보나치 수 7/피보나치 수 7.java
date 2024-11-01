import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibonacci(N));

    }
    static long fibonacci(int N){
        if (N == 0) {
            return dp[0];
        }

        if (N == 1) {
            return dp[1];
        }

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[N];
    }
}

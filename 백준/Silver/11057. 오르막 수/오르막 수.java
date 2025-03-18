import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp;
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[1001][10]; // 9개, 1000자리 수


        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1; // 초기
        }


        dp[0][0] = 0;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += (dp[i - 1][k]) % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += (dp[N][i]) % mod;
        }
        System.out.println(result % mod);
    }
}

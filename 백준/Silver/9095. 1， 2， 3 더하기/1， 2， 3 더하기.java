import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = Integer.parseInt(br.readLine());

        dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int j = 4; j <= 10; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        for (int i = 0; i < S; i++) {
            N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[301];
        stairs = new int[301];

        for (int i = 1; i <= N; i++) {
            int s = Integer.parseInt(br.readLine());
            stairs[i] = s;
        }
        dp[0] = 0;
        dp[1] = stairs[1]; //1층
        dp[2] = stairs[1] + stairs[2]; // 2층

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[N]);

    }
}

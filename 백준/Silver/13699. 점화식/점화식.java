import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        dp[0] = 1;
        

        if (N == 0) {
            System.out.println(dp[0]);
            return;
        }
        
        dp[1] = 1;
        
        int curDp = 2;

        while (curDp <= N) {
            dp[curDp] = 0;  // 초기화
            for (int i = 0; i < curDp; i++) {
                dp[curDp] += dp[i] * dp[(curDp - 1) - i];
            }
            curDp++;
        }
        System.out.println(dp[N]);
    }
}

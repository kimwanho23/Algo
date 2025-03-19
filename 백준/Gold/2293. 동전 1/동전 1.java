import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] money;
    static int[] dp; //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // n가지 종류 동전
        int K = Integer.parseInt(st.nextToken()); // 가치의 합

        money = new int[N + 1];
        dp = new int[K + 1];

        dp[0] = 1; // 0원을 만드는 경우

        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            for (int j = money[i]; j <= K; j++) {
                dp[j] += dp[j - money[i]];
            }
        }
        System.out.println(dp[K]);
    }
}

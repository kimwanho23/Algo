import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new BigInteger[N + 1];

        fibonacci(N);

    }
    static void fibonacci(int N){

        if (N == 0){
            System.out.println(0);
            return;
        }

        if (N == 1){
            System.out.println(1);
            return;
        }


        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);


        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[N]);
    }
}

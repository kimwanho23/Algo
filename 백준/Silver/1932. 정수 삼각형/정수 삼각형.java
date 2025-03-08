import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 크기

        arr = new int[N][N];
        dp = new int[N][N];

        int max = arr[0][0];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) { // j 범위를 0 ~ i로 설정
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }
                else if (j == i) { // j == i로 수정 (i+1이 아님)
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(dp[N - 1][i], max);
        }
        System.out.println(max);
    }
}

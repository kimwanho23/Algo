import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sticker;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 정수 n개

            sticker = new int[2][N];
            dp = new int[2][N][2];


            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0][0] = 0; // 줄, n, 선택 했는가?
            dp[1][0][0] = 0;

            dp[0][0][1] = sticker[0][0];
            dp[1][0][1] = sticker[1][0];

            for (int j = 1; j < N; j++) {
                dp[0][j][0] = Math.max(dp[0][j - 1][0], dp[0][j - 1][1]); // 현재를 선택하지 않는 경우
                dp[1][j][0] = Math.max(dp[1][j - 1][0], dp[1][j - 1][1]);

                dp[0][j][1] = Math.max(Math.max(dp[1][j - 1][1], dp[0][j - 1][0]), dp[1][j - 1][0]) + sticker[0][j];
                dp[1][j][1] = Math.max(Math.max(dp[0][j - 1][1], dp[0][j - 1][0]), dp[1][j - 1][0]) + sticker[1][j];
            }
            sb.append(Math.max(Math.max(Math.max(dp[0][N - 1][0], dp[0][N - 1][1]), dp[1][N - 1][0]), dp[1][N - 1][1])).append("\n");
        }
        System.out.println(sb);
    }
}

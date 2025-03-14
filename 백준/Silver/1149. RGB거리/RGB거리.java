import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] C;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 집의 수

        C = new int[K][3];
        DP = new int[K][3];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C[i][Red] = Integer.parseInt(st.nextToken());
            C[i][Green] = Integer.parseInt(st.nextToken());
            C[i][Blue] = Integer.parseInt(st.nextToken());
        }

        DP[0][Red] = C[0][Red];
        DP[0][Green] = C[0][Green];
        DP[0][Blue] = C[0][Blue];

        for (int i = 1; i < K; i++) {
            DP[i][Red] = Math.min(DP[i - 1][Blue], DP[i - 1][Green]) + C[i][Red];
            DP[i][Green] = Math.min(DP[i - 1][Blue], DP[i - 1][Red]) + C[i][Green];
            DP[i][Blue] = Math.min(DP[i - 1][Red], DP[i - 1][Green]) + C[i][Blue];
        }
        System.out.println(Math.min(Math.min(DP[K - 1][Red], DP[K -1][Green]), DP[K-1][Blue]));
    }


}

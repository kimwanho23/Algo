import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, hap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 표의 크기 N
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

        arr = new int[N + 1][N + 1];

        hap = new int[N + 1][N + 1]; // 구간 합 배열



        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        hap[1][1] = arr[1][1];

        for (int i = 2; i <= N; i++) {
            hap[i][1] = hap[i - 1][1] + arr[i][1];
            hap[1][i] = hap[1][i - 1] + arr[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                hap[i][j] = hap[i - 1][j] + hap[i][j - 1] + arr[i][j] - hap[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());

            int result = hap[x2][y2] - (hap[x2][y1- 1] + hap[x1 - 1][y2]) + hap[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] pac, one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 필요한 줄의 수 N
        int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 M

        pac = new int[M];
        one = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pac[i] = Integer.parseInt(st.nextToken()); // 패키지 가격 (기타 줄 6개)
            one[i] = Integer.parseInt(st.nextToken()); // 낱개의 가격
        }

        Arrays.sort(pac);
        Arrays.sort(one);

        int pacMin = pac[0];
        int oneMin = one[0];

        // 1. 전부 낱개로 구매할 때의 비용
        int cost1 = oneMin * N;

        // 2. 전부 패키지로 살 경우의 비용
        int cost2 = pacMin * ((N + 5) / 6); // 필요한 패키지 수

        // 3. 패키지 + 낱개 조합으로 살 경우의 비용
        int cost3 = pacMin * (N / 6) + oneMin * (N % 6);

        // 최솟값 출력
        System.out.println(Math.min(cost1, Math.min(cost2, cost3)));

    }
}

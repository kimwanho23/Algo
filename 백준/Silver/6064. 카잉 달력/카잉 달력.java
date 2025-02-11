import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine()); // 테케 개수ㅡ

        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // X
            int N = Integer.parseInt(st.nextToken()); // Y
            int x = Integer.parseInt(st.nextToken()); // x 시작값
            int y = Integer.parseInt(st.nextToken()); // y 시작값


            sb.append(solve(x, M, N, y)).append('\n');
        }

        System.out.println(sb);
    }

    static int solve(int x, int M, int N, int y) {
        if (x == M) x = 0;
        if (y == N) y = 0;

        int p = lcd(M,N);
        for (int j = x; j <= p; j += M) {
            if (j == 0) continue;
            if (j % N == y) {
                return j;
            }
        }
        return -1;
    }

    static int gcd(int a, int b){
       if (a == 0) return b;
       return gcd(b % a,a);
    }
    static int lcd(int a, int b) {
        return a / gcd(a, b) * b;
    }
}

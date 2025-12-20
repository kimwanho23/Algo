import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static boolean[] prime;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        prime = isPrime(N);

        for (int i = M; i <= N; i++) {
            if (prime[i]) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }

    static boolean[] isPrime(int N) {
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

}

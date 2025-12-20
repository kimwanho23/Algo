import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }
        prime = isPrime(max);

        for (int n : arr) {
            int count = 0;
            int left = 2;
            int right = n - 2;

            while (left <= right) {
                if (prime[left] && prime[right]) {
                    count++;
                }
                left++;
                right--;
            }
            sb.append(count).append('\n');
        }

        System.out.print(sb);

    }
    static boolean[] isPrime(int n){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}

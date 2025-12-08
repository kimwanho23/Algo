import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (min == Integer.MAX_VALUE){
                    min = i;
                }
                sum+=i;
            }
        }
        if (sum != 0){
            System.out.println(sum);
            System.out.println(min);
        }
        else {
            System.out.println(-1);
        }

        br.close();
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

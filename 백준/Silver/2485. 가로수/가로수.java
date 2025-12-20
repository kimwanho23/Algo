import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N]; // 가로수의 위치
        Long[] min = new Long[N - 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < min.length; i++) {
            min[i] = arr[i + 1] - arr[i];
        }

        long gcd = min[0];

        for (int i = 1; i < min.length; i++) {
            gcd = gcd(gcd, min[i]);
        }

        Long first = arr[0];
        Long last = arr[N - 1];

        System.out.println((last - first) / gcd - min.length);

    }

    public static Long gcd(Long a, Long b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }


}

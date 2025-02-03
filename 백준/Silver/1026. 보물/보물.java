import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static Integer[] A, B;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}

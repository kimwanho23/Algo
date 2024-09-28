import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] A;
    static int[] B;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
            P[i] = 0;
        }
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (B[j] == A[i]){
                    P[i] = j;
                    B[j] = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 개수
        int M = Integer.parseInt(st.nextToken()); //

        arr = new int[N];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int end = 0;
        for (int s = 0; s < N; s++) {
            while (end < N && arr[end] - arr[s] < M)
                end++;
            if (end == N) break;
            min = Math.min(min, arr[end] - arr[s]);
        }
        System.out.println(min);


    }

}

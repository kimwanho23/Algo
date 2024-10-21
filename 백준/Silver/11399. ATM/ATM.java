import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        result = new int[N];
        count = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result[0] = arr[0];
        for (int i = 1; i < N; i++) {
            result[i] =  result[i - 1] + arr[i];
        }
        for (int i = 0; i < N; i++) {
            count += result[i];
        }
        System.out.println(count);
    }
}

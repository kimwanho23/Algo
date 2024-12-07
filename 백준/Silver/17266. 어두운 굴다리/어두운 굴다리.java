import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int left, right;
    static int[] arr, distance;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이 N
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수 M

        arr = new int[M];
        distance = new int[M - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if (i >= 1) {
                distance[i - 1] = arr[i] - arr[i - 1];
                result = Math.max((distance[i - 1] + 1) /2, result);
            }
        }
        result = Math.max(Math.max(arr[0], N - arr[M - 1]), result);
        System.out.println(result);
    }
}

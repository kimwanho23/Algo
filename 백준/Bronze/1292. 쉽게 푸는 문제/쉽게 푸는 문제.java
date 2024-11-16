import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, hap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        arr = new int[1001];
        hap = new int[1001];

        int count = 1;
        int current = 1;

        while (current < 1001) {
            int cur = current;
            for (int i = current; i < count + cur; i++) {
                arr[i] = count;
                current++;
                if (current > 1000)
                    break;
            }
            count++;
        }
        for (int i = 1; i < 1001; i++) {
            hap[i] = hap[i - 1] + arr[i]; // 구간 합 배열
        }

        System.out.println(hap[end] - hap[start - 1]);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //
        int S = Integer.parseInt(st.nextToken()); // 부분합 크기 s 이상

        int min = Integer.MAX_VALUE;

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0; // end 0부터.
        int current = arr[0]; // 처음 숫자
        int length = 1; // 기본값

        if (current >= S) { // 초기값에서 끝날 때는 1
            System.out.println(1);
            return;
        }

        for (int start = 0; start < N; start++) {
            if (current >= S) {
                current -= arr[start - 1];
                length--;
                if (current >= S) {
                    min = Math.min(min, length);
                }
            }

            while (end < N && current < S) {
                end++; // end 값 증가
                if (end == N) break;
                current += arr[end]; // 현재 값에서 arr[end] 증가
                length++;
                if (current >= S) {
                    min = Math.min(length, min);
                }
            }


        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }
}

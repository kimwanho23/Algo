import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            int test_case_Num = Integer.parseInt(st.nextToken());
            arr = new int[20];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (arr[k] > arr[j]) {
                        count++;
                    }
                }
            }
            sb.append(test_case_Num).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}

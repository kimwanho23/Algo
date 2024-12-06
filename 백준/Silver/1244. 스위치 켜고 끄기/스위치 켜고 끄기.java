import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 스위치 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine()); // 학생 수

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 성별
            int button = Integer.parseInt(st.nextToken()); // 버튼

            if (gender == 1) { // 남학생인 경우
                int count = 1;
                while (button * count <= N) {
                    arr[button * count] = (arr[button * count] + 1) % 2;
                    count++;
                }
                continue;
            }
            if (gender == 2){
                arr[button] = (arr[button] + 1) % 2;
                int count = 1;
                while (button + count <= N && button - count > 0) {
                    if (arr[button + count] == arr[button - count]) {
                        arr[button + count] = (arr[button + count] + 1) % 2;
                        arr[button - count] = (arr[button - count] + 1) % 2;
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= N ; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 초기 수
        int M = Integer.parseInt(st.nextToken()); // 목표 수

        int count = 0;
        int s = M;
        while (s != N) {
            if (s < N) {
                System.out.println(-1);
                return;
            }
            if (s % 10 == 1){
                s = s / 10;
                count++;
            } else if (s % 2 == 0) {
                s = s / 2;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count + 1);
    }
}

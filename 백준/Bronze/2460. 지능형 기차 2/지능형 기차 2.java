import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int current = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int down = Integer.parseInt(st.nextToken());
            int top = Integer.parseInt(st.nextToken());

            current -= down; // 내리고
            current += top; // 탄다

            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}

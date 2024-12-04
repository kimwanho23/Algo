import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()); // W개
        int H = Integer.parseInt(st.nextToken()); // H행
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                count++;
                j += M;
            }
            i += N;
        }
        System.out.println(count);

    }
}

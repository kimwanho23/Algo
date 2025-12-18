import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원판의 개수


        sb.append((int)Math.pow(2, N) - 1).append("\n");

        Hanoi(N, 1,2,3);
        System.out.println(sb);

    }
    public static void Hanoi(int N, int start, int mid, int to) {
        if (N == 1){
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        Hanoi(N - 1, start, to, mid);

        sb.append(start).append(" ").append(to).append("\n");

        Hanoi(N - 1, mid, start, to);
    }

}

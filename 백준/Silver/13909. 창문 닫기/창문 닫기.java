import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 창문 개수 = 사람 개수
        int count = 0;

        for(int i = 1; i * i <= N; i++) { //제곱수만 카운트
            count++;
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1){
            System.out.println(1);
            return;
        }

        int count = 1; // 기본 카운트
        int loop = 1;

        while (true){
            loop += 6 * count;
            count++;
            if (N > loop){
            }
            else {
                System.out.println(count);
                break;
            }
        }
    }
}

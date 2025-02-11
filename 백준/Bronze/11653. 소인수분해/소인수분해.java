import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int index = 2;
        while (N != 1) {
            if (N % index == 0) {
                sb.append(index).append("\n");
                N = N / index;
                index = 2;
            } else {
                index++;
            }
        }
        System.out.println(sb);
    }
}

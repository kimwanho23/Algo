import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        long s = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        while (s >= b) {
            long n = s % b;
            s = s / b;
            if (n > 9) {
                char cur = (char)(n + 55);
                sb.append(cur);
            } else {
                sb.append(n);
            }
        }
        if (s > 9) {
            char cur = (char)(s + 55);
            sb.append(cur);
        } else {
            sb.append(s);
        }

        System.out.println(sb.reverse());
    }
}

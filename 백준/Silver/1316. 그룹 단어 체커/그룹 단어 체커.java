import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (isGroup(s)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isGroup(String s) {
        boolean[] b = new boolean[26];

        int start = s.charAt(0) - 'a';
        b[start] = true; // 초기값

        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            if (s.charAt(i) != s.charAt(i - 1) && b[current]) {
                return false;
            } else {
                b[current] = true;
            }
        }
        return true;
    }
}

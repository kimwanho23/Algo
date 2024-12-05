import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean condition; // 조건, 자음 모음 판별
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            condition = false;


            for (int i = 0; i < s.length(); i++) {

                if (isVowel(s.charAt(i))) {
                    condition = true; // 1번 조건 충족
                }
                if (i > 0) {
                    if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                        condition = false;
                        break;
                    }
                }
                if (i > 1) {
                    if ((isVowel(s.charAt(i)) && isVowel(s.charAt(i - 1)) && isVowel(s.charAt(i - 2)))
                            || (!isVowel(s.charAt(i)) && !isVowel(s.charAt(i - 1)) && !isVowel(s.charAt(i - 2)))) {
                        condition = false;
                        break;
                    }
                }

            }
            if (condition) {
                sb.append("<").append(s).append("> ").append("is acceptable.").append("\n");
            } else {
                sb.append("<").append(s).append("> ").append("is not acceptable.").append("\n");
            }

        }
        System.out.println(sb);
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

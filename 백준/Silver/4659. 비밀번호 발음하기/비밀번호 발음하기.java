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

                if (String.valueOf(s.charAt(i)).matches("[aeiou]")) {
                    condition = true; // 1번 조건 충족
                }
                if (i > 0) {
                    if (s.charAt(i) == s.charAt(i - 1)){
                        if (!String.valueOf(s.charAt(i)).matches("[eo]")){
                            condition = false;
                            break;
                        }
                    }
                }
                if (i > 1) {
                    if ((String.valueOf(s.charAt(i)).matches("[aeiou]")
                            && String.valueOf(s.charAt(i - 1)).matches("[aeiou]")
                            && String.valueOf(s.charAt(i - 2)).matches("[aeiou]") ||
                            (!String.valueOf(s.charAt(i)).matches("[aeiou]")
                                    && !String.valueOf(s.charAt(i - 1)).matches("[aeiou]")
                                    && !String.valueOf(s.charAt(i - 2)).matches("[aeiou]")
                            ))){
                        condition = false;
                        break;
                    }
                }

            }
            if (condition){
                sb.append("<").append(s).append("> ").append("is acceptable.").append("\n");
            } else {
                sb.append("<").append(s).append("> ").append("is not acceptable.").append("\n");
            }

        }
        System.out.println(sb);
    }
}

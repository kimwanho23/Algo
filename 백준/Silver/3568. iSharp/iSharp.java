import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String ch = "&"; // 참조
    static final String pointer = "*"; // 포인터
    static final String arr = "]"; // 배열1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String v = st.nextToken(); // 공통 영역

        int var = st.countTokens(); // 변수 개수

        for (int i = 0; i < var; i++) {
            String s = st.nextToken();
            s = s.replace(",", "").replace(";", "");
            String va = "";

            for (int j = s.length() - 1; j >= 0; j--) {
                String cur = String.valueOf(s.charAt(j));
                if (cur.equals(ch) || cur.equals(pointer)) {
                    va += cur;
                } else if (cur.equals(arr)) {
                    va += "[]";
                    j--;
                } else {
                    va += " ";
                    va += s.substring(0, j + 1);
                    break;
                }
            }
            sb.append(v).append(va).append(";\n");
        }
        System.out.println(sb);
    }
}

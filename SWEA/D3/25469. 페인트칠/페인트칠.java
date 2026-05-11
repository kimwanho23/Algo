import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

class Solution
{
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) {
            st =  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 세로
            int m = Integer.parseInt(st.nextToken()); // 가로
            String[][] arr = new String[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = String.valueOf(s.charAt(j));
                }
            }
            int count = 0;

            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (!Objects.equals(arr[i][j], "#")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }

            for (int i = 0; i < m; i++) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (!Objects.equals(arr[j][i], "#")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            if (count == n + m) {
                sb.append(Math.min(n,m)).append("\n");
            } else {
                sb.append(count).append("\n");
            }

        }
        System.out.println(sb);
    }
}
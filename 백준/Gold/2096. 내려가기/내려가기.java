import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int max0 = 0, max1 = 0, max2 = 0;
        int min0 = 0, min1 = 0, min2 = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max0 = min0 = x1;
                max1 = min1 = x2;
                max2 = min2 = x3;
            } else {
                int prevMax0 = max0, prevMax2 = max2;
                int prevMin0 = min0, prevMin2 = min2;

                // 최대값 갱신
                max0 = Math.max(max0, max1) + x1;
                max2 = Math.max(max1, max2) + x3;
                max1 = Math.max(Math.max(prevMax0, max1), prevMax2) + x2;

                // 최소값 갱신
                min0 = Math.min(min0, min1) + x1;
                min2 = Math.min(min1, min2) + x3;
                min1 = Math.min(Math.min(prevMin0, min1), prevMin2) + x2;
            }
        }
        
        int max = Math.max(Math.max(max0, max1), max2);
        int min = Math.min(Math.min(min0, min1), min2);

        System.out.println(max + " " + min);
    }
}

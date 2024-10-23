import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long[] tree;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수 N
        long M = Long.parseLong(st.nextToken()); // 나무 길이 M

        st = new StringTokenizer(br.readLine());
        tree = new Long[N];
        result = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            long H = Long.parseLong(st.nextToken()); // 나무의 높이 H
            if (H > max){
                max = H;
            }
            tree[i] = H;
        }

        long start = 0; //
        long end = max; // 가장 높은 나무

        while (start < end){
            long middle = (start + end) / 2; // 자르는 길이
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] - middle > 0){
                    total += (tree[i] - middle); // 나무를 잘랐을 때 총량
                }
            }
            if (M == total){
                System.out.println(middle);
                return;
            }
            else if (total < M){
                end = middle; // 총량이 작다면, 나무를 낮게 자른다.
            }
            else {
                start = middle + 1; // 크다면 높게 자른다.
            }
        }

        System.out.println(start - 1);

    }
}

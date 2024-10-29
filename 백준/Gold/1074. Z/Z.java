import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //
        r = Integer.parseInt(st.nextToken()); // r행
        c = Integer.parseInt(st.nextToken()); // c열

        int size = (int) Math.pow(2, N);
        partition(size, r, c);
        System.out.println(count);
        

    }
    static void partition(int size, int r, int c){

        if (size == 1)
            return;

        if (r < size / 2 && c < size / 2){ // 2사분면
            partition(size / 2, r, c);
        }
        else if (r < size / 2 && c >= size / 2){// 3사분면
            count += (size * size / 4);
            partition(size / 2, r, c - size / 2);
        }
        else if (r >= size / 2 && c < size / 2){ // 1사분면
            count += size * size / 4 * 2;
            partition(size / 2, r - size / 2, c);
        }
        else {
            count += (size * size / 4) * 3; // 4사분면
            partition(size / 2, r - size / 2, c - size / 2);
        }
    }
}

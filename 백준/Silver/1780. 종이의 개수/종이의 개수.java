import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] D;
    static int one;
    static int zero;
    static int minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        D = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0 , N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    static void partition(int row, int col, int size){
        if (colorCheck(row, col, size)){
            if (D[row][col] == 1){
                one++;
            }
            else if (D[row][col] == 0){
                zero++;
            }
            else {
                minus++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2 * newSize, col, newSize);
        partition(row + 2 * newSize, col + newSize, newSize);
        partition(row + 2 * newSize, col + 2 * newSize, newSize);

    }

    static boolean colorCheck(int row, int col, int size){
        int color = D[row][col]; // 첫 번째 요소 색상으로 판단

        for (int i = row; i < row + size ; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != D[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

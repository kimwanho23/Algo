import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = m * n;
        for(int row = 0; row <= n - 8; row++) {
            for(int col = 0; col <= m - 8; col++) {
                int tmp = Math.min(minChess('B', row, col), minChess('W', row, col));
                min = Math.min(min, tmp);
            }
        }

        System.out.println(min);
        br.close();
    }
    public static int minChess(char color, int row, int col){
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) {
                    count = (board[row + i][col + j] != color) ? count + 1 : count;
                } else {
                    count = (board[row + i][col + j] == color) ? count + 1 : count;
                }
            }
        }
        return count;
    }
}

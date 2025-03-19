import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alpha;
    static int max;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // R개의 줄
        C = Integer.parseInt(st.nextToken()); // C개의 줄


        board = new char[R][C];
        visited = new boolean[R][C];
        alpha = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        DFS(0,0, 1);
        System.out.println(max);
    }
    static void DFS(int x, int y, int count)  {

        visited[x][y] = true;
        alpha[board[x][y] - 'A'] = true;

        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;

            if (visited[nextX][nextY] || alpha[board[nextX][nextY] - 'A']) continue;

            DFS(nextX, nextY, count + 1);
        }

        visited[x][y] = false;
        alpha[board[x][y] - 'A'] = false;

    }

}

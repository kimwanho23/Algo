import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] pic;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기 n
        M = Integer.parseInt(st.nextToken()); // 가로 크기 M

        pic = new int[N][M];
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pic[i][j] == 1 && !visited[i][j]) {
                    count++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y ));
        visited[x][y] = true;
        int ans = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int curX = p.x;
            int curY = p.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;
                if (pic[nextX][nextY] == 0) continue;

                ans++;
                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY));
            }
        }
        max = Math.max(ans, max);
    }
}

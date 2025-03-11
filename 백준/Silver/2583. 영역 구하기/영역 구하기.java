import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] tri;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int M, N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로 꼭짓점 좌표 N, M
        int K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        tri = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    tri[j][k] = 1;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (tri[j][k] == 0 && !visited[j][k]) {
                    BFS(j, k);
                }
            }
        }
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);

    }
    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int count = 1;

         while (!q.isEmpty()) {
             Point cur = q.poll();
             int curX = cur.x;
             int curY = cur.y;

             for (int i = 0; i < 4; i++) {
                 int nextX = curX + dx[i];
                 int nextY = curY + dy[i];

                 if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                     continue;
                 }

                 if (visited[nextX][nextY]) continue;
                 if (tri[nextX][nextY] == 1) continue;


                 visited[nextX][nextY] = true;
                 q.add(new Point(nextX, nextY));

                 count++;
             }
         }
         pq.add(count);
    }
}

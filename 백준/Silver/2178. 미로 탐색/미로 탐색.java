import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze; // 미로
    static int[][] distance; // 거리
    static boolean[][] visited; // 방문 여부

    static int N, M;

    static int[] dx = {-1, 0, 1, 0 };
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        BFS(0, 0);
        System.out.println(distance[N - 1][M - 1]);

    }

    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x, y);
        q.add(p);
        distance[x][y] = 1;
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (maze[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                q.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[now.x][now.y] + 1;
                visited[nextX][nextY] = true;

            }
        }


    }
}

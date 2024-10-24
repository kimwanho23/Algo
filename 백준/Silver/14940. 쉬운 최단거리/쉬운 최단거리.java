import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] distance;
    static int x, y, N, M;
    static int[] dx = {1, 0, -1, 0}; // 남, 서, 북, 동
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2){ // 목표 지점
                    x = i;
                    y = j;
                }
                distance[i][j] = 0;
            }
        }
        bfs(x, y); // 시작 좌표는 (x,y)


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]){
                    if (arr[i][j] == 0){
                        sb.append(0).append(" ");
                    } else {
                        sb.append(-1).append(" ");
                    }
                }
                else{
                    sb.append(distance[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (arr[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                q.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[p.x][p.y] + 1;
                visited[nextX][nextY] = true;
            }
        }



    }
}

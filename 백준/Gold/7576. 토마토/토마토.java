import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int[][] box;
    static boolean[][] visited;
    static int[][] result;
    static List<Point> begin;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1 ,0, -1};
    static int sum = 0;

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken()); // 가로 칸
        N = Integer.parseInt(st.nextToken()); // 세로 칸


        box = new int[N][M];
        visited = new boolean[N][M];
        result = new int[N][M];
        begin = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                box[i][j] = cur;
                result[i][j] = 0;
                if (cur == 1){
                    begin.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0 && !visited[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(sum);

    }
    static void BFS(){
        Queue<Point> q = new LinkedList<>(begin);

        while (!q.isEmpty()){
            Point p = q.poll(); // 현재
            int count = result[p.x][p.y];

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue; // 인덱스를 벗어나거나
                if (visited[nextX][nextY])
                    continue; // 이미 방문했거나
                if (box[nextX][nextY] == -1)
                    continue; // 들어있지 않은 칸(막혀있는 길)

                result[nextX][nextY] = count + 1;
                sum = Math.max(result[nextX][nextY], sum);
                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY));
            }
        }
    }
}

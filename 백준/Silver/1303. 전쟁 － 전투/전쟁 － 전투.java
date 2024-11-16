import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] war;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, black, white;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        war = new char[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                war[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j])
                    BFS(i, j);
            }
        }
        System.out.println(white + " " + black);

    }

    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        if (war[x][y] == 'B') {
            check = true;
        } else check = false;

        int tmp = 1;

        while (!q.isEmpty()){
            Point p = q.poll(); // 현재 좌표

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue; // 범위 초과
                if (visited[nextX][nextY]) continue; // 이미 방문
                if (war[nextX][nextY] != war[x][y]) continue; //서로 다른 병사

                visited[nextX][nextY] = true;
                tmp++;
                q.add(new Point(nextX, nextY));
            }
        }

        if (check) black += (int) Math.pow(tmp, 2);
        else white += (int) Math.pow(tmp, 2);
    }
}

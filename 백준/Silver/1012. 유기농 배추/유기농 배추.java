import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 , 0};
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            field = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;  // 배추가 있는 위치 표시
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && field[i][j] == 1) {
                        count++; // 선 카운트 증가
                        DFS(i, j); // 방문 처리
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x, int y) {
        Stack<Point> s = new Stack<>();
        visited[x][y] = true;
        s.add(new Point(x, y));

        while (!s.isEmpty()) {
            Point p = s.pop();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (field[nextX][nextY] != 1) {
                    continue;
                }
                s.push(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }
}
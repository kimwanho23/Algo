import java.util.LinkedList;
import java.util.Queue;

public class Solution{

    class Visit {
        int x;      // 열
        int y;      // 행
        int cost;   // 이동 횟수

        public Visit(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    // 상, 하, 좌, 우 (y, x 기준)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int width, height;
    static boolean[][] visited;
    static char[][] board;

    static int startX, startY;
    static int endX, endY;

    public int solution(String[] input) {
        height = input.length;         // 행
        width = input[0].length();     // 열

        board = new char[height][width];
        visited = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x] = input[y].charAt(x);

                if (board[y][x] == 'R') {
                    startX = x;
                    startY = y;
                } else if (board[y][x] == 'G') {
                    endX = x;
                    endY = y;
                }
            }
        }

        return bfs();
    }

    // 범위 밖이거나, 'D' 이면 true = 더 이상 진행 불가
    private boolean isWallOrOut(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return true;
        }
        return board[y][x] == 'D';
    }

    private int bfs() {
        Queue<Visit> q = new LinkedList<>();
        q.add(new Visit(startX, startY, 0));
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            Visit cur = q.poll();

            if (cur.x == endX && cur.y == endY) {
                return cur.cost;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x;
                int ny = cur.y;

                // 한 방향으로 끝까지 미끄러지기
                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];

                    if (isWallOrOut(tx, ty)) {
                        break; // 더 못 가면 stop
                    }

                    nx = tx;
                    ny = ty;
                }

                // 한 칸도 못 움직였으면 스킵
                if (nx == cur.x && ny == cur.y) continue;

                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;

                q.add(new Visit(nx, ny, cur.cost + 1));
            }
        }
        return -1;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ToPoint {
    int x, y, z;

    public ToPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int[][][] box;
    static int M, N, H;
    static int unripeTomatoes = 0;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        ArrayDeque<ToPoint> q = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.add(new ToPoint(i, j, k));  // 익은 토마토 큐에 추가
                    } else if (box[i][j][k] == 0) {
                        unripeTomatoes++;  // 익지 않은 토마토 수 카운팅
                    }
                }
            }
        }

        int days = BFS(q);

        // 모든 토마토가 익지 못한 경우 -1 반환
        if (unripeTomatoes > 0) {
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }

    static int BFS(ArrayDeque<ToPoint> q) {
        int days = -1;  // 첫날 초기화로 -1 시작 (큐에서 첫 레벨 때 증가)
        
        while (!q.isEmpty()) {
            int size = q.size();
            days++;
            
            for (int i = 0; i < size; i++) {
                ToPoint tp = q.poll();

                for (int j = 0; j < 6; j++) {
                    int nextX = tp.x + dx[j];
                    int nextY = tp.y + dy[j];
                    int nextZ = tp.z + dz[j];

                    if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= H || nextY >= N || nextZ >= M)
                        continue;
                    if (box[nextX][nextY][nextZ] != 0)
                        continue;

                    box[nextX][nextY][nextZ] = 1;  // 방문 처리하여 익음 표시
                    q.add(new ToPoint(nextX, nextY, nextZ));
                    unripeTomatoes--;  // 익지 않은 토마토 수 감소

                    // 모든 토마토가 익었을 경우 조기 종료
                    if (unripeTomatoes == 0) {
                        return days + 1;
                    }
                }
            }
        }
        return days;
    }
}
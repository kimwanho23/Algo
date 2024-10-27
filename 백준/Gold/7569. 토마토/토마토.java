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
    static boolean[][][] visited;
    static int[][][] result;
    static List<ToPoint> begin;
    static int sum = 0;

    static int[] dx = {-1, 1, 0, 0, 0 ,0};
    static int[] dy = {0, 0, 1 ,-1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 5
        N = Integer.parseInt(st.nextToken()); // 3
        H = Integer.parseInt(st.nextToken()); // 1


        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        result = new int[H][N][M];
        begin = new LinkedList<>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1){
                        begin.add(new ToPoint(i, j ,k));
                        visited[i][j][k] = true;
                    }
                    result[i][j][k] = 0;
                }
            }
        }
        BFS();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if (box[i][j][k] == 0 && !visited[i][j][k]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(sum);

    }
    static void BFS(){
        Queue<ToPoint> q = new LinkedList<>(begin);
        while (!q.isEmpty()){
            ToPoint tp = q.poll();
            int count  = result[tp.x][tp.y][tp.z];
            for (int i = 0; i < 6; i++) {
                int nextX = tp.x + dx[i];
                int nextY = tp.y + dy[i];
                int nextZ = tp.z + dz[i];

                if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= H || nextY >= N || nextZ >= M)
                    continue;
                if (visited[nextX][nextY][nextZ])
                    continue;
                if (box[nextX][nextY][nextZ] == -1)
                    continue;


                result[nextX][nextY][nextZ] = count + 1;
                visited[nextX][nextY][nextZ] = true;
                sum = Math.max(result[nextX][nextY][nextZ], sum);


                q.add(new ToPoint(nextX, nextY, nextZ));
            }
        }
    }
}

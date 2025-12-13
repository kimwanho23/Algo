import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 인원 수

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    public static void dfs(int index, int count){
        if (count == N / 2) {
            calc();
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    public static void calc(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int value = Math.abs(team_start - team_link);

        if (value == 0) {
            System.out.println(value);
            System.exit(0);
        }
        min = Math.min(value, min);
    }
}

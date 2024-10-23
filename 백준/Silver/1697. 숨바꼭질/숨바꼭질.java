import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치 N
        K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치 K

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        visited = new int[100001];
        BFS(N);
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = 1; // 출발 지점을 1로 표시
        q.add(node);

        while (!q.isEmpty()) {
            int now_node = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = now_node + 1;
                } else if (i == 1) {
                    next = now_node - 1;
                } else {
                    next = now_node * 2;
                }

                if (next == K) {
                    System.out.println(visited[now_node]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[now_node] + 1;
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문 배열
    static ArrayList<Integer>[] graph; // 그래프
    static int N, M, V;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
        sb = new StringBuilder();

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph[S].add(E);
            graph[E].add(S);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화
        sb.append(V).append(" ");
        DFS(V);
        sb.append("\n");
        visited = new boolean[N + 1]; // 방문 배열 초기화
        BFS(V);

        System.out.println(sb);
    }

    private static void DFS(int node) { // DFS 수행
        visited[node] = true;

        for (int i : graph[node]){
            if (!visited[i]){
                sb.append(i).append(" ");
                DFS(i);
            }
        }
    }

    private static void BFS(int node) { // BFS 수행
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        sb.append(node).append(" "); // 초기

        while (!q.isEmpty()){
            int now_node = q.poll();
            for (int i : graph[now_node]) {
                if (!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
        sb.append("\n");
    }
}

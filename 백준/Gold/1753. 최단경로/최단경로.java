import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph implements Comparable<Graph>{
    int node;
    int cost;

    public Graph(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Graph o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int V; // 정점의 개수
    static int K; // 시작 정점
    static int E; // 간선의 개수
    static List<Graph>[] graph; // 그래프를 표현하는 인접 리스트
    static int[] distance; // 최단 거리 배열
    static final int INF = 1000000; //무한대를 나타내는 값

    static void dijkstra(int start) {
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Graph> queue = new PriorityQueue<>();
        queue.offer(new Graph(start, 0)); // 시작 그래프

        while (!queue.isEmpty()) {
            Graph edge = queue.poll();
            int u = edge.node; // 우선순위 큐에서 가장 가까운 노드

            if (!visited[u]) {
                visited[u] = true; // 방문 처리

                for (Graph g : graph[u]) {
                    int node = g.node;
                    int cost = g.cost;

                    // 현재 노드를 방문하지 않았고, 현재 노드 + 가중치가 노
                    if (!visited[node] && distance[u] + cost < distance[node]) {
                        distance[node] = distance[u] + cost;
                        queue.add(new Graph(node, distance[node]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 시작 정점의 번호

        graph = new LinkedList[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new LinkedList<Graph>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 끝 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치
            graph[u].add(new Graph(v, w));
        }

        // 다익스트라 알고리즘 실행
        dijkstra(K);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}

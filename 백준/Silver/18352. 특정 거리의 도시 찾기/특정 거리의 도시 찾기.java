import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] city;
    static boolean[] visited;
    static int[] answer;
    static int N, M, K, X;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수 N
        M = Integer.parseInt(st.nextToken()); // 도로의 개수 M
        K = Integer.parseInt(st.nextToken()); // 거리 정보 K
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 X

        city = new ArrayList[N + 1]; //1번 부터 N번
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        Arrays.fill(answer, -1);
        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // A번 도시
            int B = Integer.parseInt(st.nextToken()); // B번 도시

            city[A].add(B);
        }

        BFS(X);
        for (int i = 1; i <= N; i++) {
            if (answer[i] == K){
                sb.append(i).append("\n");
            }
        }
        if (sb.isEmpty()){
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        answer[node] = 0;
        visited[node] = true;
        while (!q.isEmpty()){
            int n = q.poll(); // 첫 노드
            for (int i : city[n]) {
                if (!visited[i]){
                    answer[i] = answer[n] + 1;
                    visited[i] = true;
                    q.add(i);
                }
            }

        }
    }
}

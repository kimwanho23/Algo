import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 노드의 개수

        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
            list[E].add(S);
        }
        BFS(1);
        for (int i = 2; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }
    static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();

        q.add(root); // 루트 노드
        visited[root] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int child : list[parent]) {
                if (!visited[child]) {
                    visited[child] = true; // 방문 처리 추가
                    q.add(child);
                    arr[child] = parent; // 부모 저장
                }
            }
        }
    }
}
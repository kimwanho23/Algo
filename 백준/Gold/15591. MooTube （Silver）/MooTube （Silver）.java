import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }

    static ArrayList<Node>[] usado;
    static boolean[] visited;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 동영상
        int Q = Integer.parseInt(st.nextToken()); // Q개의 줄


        usado = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            usado[i] = new ArrayList<>();
        }

        //USADO = 동영상의 경로
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 동영상 p
            int q = Integer.parseInt(st.nextToken()); // 동영상 q
            int r = Integer.parseInt(st.nextToken()); // USADO R
            usado[p].add(new Node(q, r));
            usado[q].add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // usado가 K 이상인 모든 동영상 추천
            int v = Integer.parseInt(st.nextToken()); // v에서 탐색 시작, k 이상인 값 탐색

            BFS(v, k);
        }

        System.out.println(sb);

    }
    static void BFS(int start, int value) {
        visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, Integer.MAX_VALUE));
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node next : usado[cur.end]) {
                if (visited[next.end]) continue;
                visited[next.end] = true;

                int minUsado = Math.min(cur.value, next.value); // 경로상의 최소 USADO
                if (minUsado >= value) count++;

                q.add(new Node(next.end, minUsado));
            }
        }
        sb.append(count).append("\n");
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] com;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        count = 0;
        com = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            com[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            com[a].add(b);
            com[b].add(a);
        }

        BFS(1);
        System.out.println(count);
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int cur_node = q.poll();

            for (int i : com[cur_node]) {
                if (!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    count++;

                }

            }
        }
    }
}

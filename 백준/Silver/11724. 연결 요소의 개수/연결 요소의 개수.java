import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        count = 0;
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i < arr.length; i++) {
            BFS(i);
        }
        System.out.println(count);

    }
    static void BFS(int node){
        if (visited[node]){
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        count++;

        while (!q.isEmpty()){
            int now_node = q.poll();

            for (int i : arr[now_node]) {
                if (!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}

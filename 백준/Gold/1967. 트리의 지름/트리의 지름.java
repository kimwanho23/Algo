import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int end;
        int weight; // 가중치

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 노드의 개수


        arr = new ArrayList[N + 1]; // 1-based index 사용
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }

        for (int i = 1; i < arr.length; i++) {
            visited = new boolean[N + 1];
            DFS(i, 0);
        }

        System.out.println(max);
    }
    static void DFS(int node, int value) {
        visited[node] = true;
        max = Math.max(max, value);

        for (Node i : arr[node]) {
            if (!visited[i.end]) {
                visited[i.end] = true;
                DFS(i.end, value + i.weight);
            }
        }
    }
}

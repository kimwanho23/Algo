import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] inDegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A].add(B);
            inDegree[B]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int start = q.poll();
            sb.append(start).append(" ");

            for (Integer current : arr[start]) {
                inDegree[current]--;
                if (inDegree[current] == 0){
                    q.add(current);
                }
            }
        }
        System.out.println(sb);
    }
}

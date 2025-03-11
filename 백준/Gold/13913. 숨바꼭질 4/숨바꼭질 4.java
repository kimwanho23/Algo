import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] D;
    static int[] backtrack; // 추적 배열
    static int N, K;
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        D = new int[100001];
        backtrack = new int[100001];
        Arrays.fill(D, -1);
        Arrays.fill(backtrack, -1);

        N = Integer.parseInt(st.nextToken()); // 현재 위치
        K = Integer.parseInt(st.nextToken()); // 목표 위치

        BFS(N);


        int answer = K;
        while (answer != -1) {
            s.push(answer);
            answer = backtrack[answer];
        }

        sb.append(D[K]).append("\n");
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }
    static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        D[x] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == K)
                return;
            int nextPoint;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nextPoint = current + 1;
                } else if (i == 1) {
                    nextPoint = current - 1;
                } else {
                    nextPoint = 2 * current;
                }

                if (nextPoint < 0 || nextPoint >= 100001) continue;
                if (D[nextPoint] != -1) continue;

                D[nextPoint] = D[current] + 1;
                backtrack[nextPoint] = current;
                q.add(nextPoint);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snake;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        ladder = new LinkedHashMap<>();
        snake = new LinkedHashMap<>();
        visited = new int[101];



        for (int i = 2; i <= 100; i++) {
            visited[i] = i - 1;
        }


        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s > e){
                snake.put(s, e);
            } else {
                ladder.put(s, e);
            }
        }

        BFS();
        System.out.println(visited[100]);
    }
    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;

        while (!q.isEmpty()){
            int now = q.poll();
            int count = visited[now]; // 현재 방문

            for (int i = 1; i <= 6; i++) {
                int nextValue = now + i;
                if (nextValue > 100)
                    continue;

                int finalPosition = nextValue;

                if (snake.containsKey(nextValue)) {
                    finalPosition = snake.get(nextValue);
                } else if (ladder.containsKey(nextValue)) {
                    finalPosition = ladder.get(nextValue);
                }

                if (visited[finalPosition] > count + 1) {
                    visited[finalPosition] = count + 1;
                    q.add(finalPosition);
                }
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    
    public static int solution(int x, int y, int n) {
        visited = new boolean[1000001];
        return bfs(x,y,n,0);
    }


    public static int bfs(int x, int y, int n, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, c});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int one = poll[0] * 2;
            int two = poll[0] * 3;
            int three = poll[0] + n;

            int[] next = new int[]{one, two, three};

            for (int cur : next) {
                if (cur > y) continue;

                if (cur == y)
                    return poll[1] + 1;

                if (!visited[cur]) {
                    q.add(new int[]{cur, poll[1] + 1});
                    visited[cur] = true;
                }
            }

        }
        return -1;
    }
}
import java.util.*;

class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] depthArray;
    
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        depthArray = new int[n + 1]; // 깊이 배열
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }

        BFS(1);

        Arrays.sort(depthArray);
        int max = depthArray[n];
        answer = (int) Arrays.stream(depthArray).filter(num -> num == max).count();
        return answer;
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i : arr[cur]) {
                if (visited[i]) {
                    continue;
                }
                q.add(i);
                visited[i] = true;
                depthArray[i] = depthArray[cur] + 1;
            }
        }
    }
}
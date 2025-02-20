class Solution {
    static boolean[] visited;
    static int answer;
    
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(dungeons, 0, k);
        return answer;
    }

    public static void DFS(int [][] dungeons, int depth, int k) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                DFS(dungeons, depth + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}
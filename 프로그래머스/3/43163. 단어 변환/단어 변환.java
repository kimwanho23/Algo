class Solution {

    static int min = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = 0;

        DFS(words, visited, begin, target, answer);
        return min != Integer.MAX_VALUE ? min : 0;
    }

    public static void DFS(String[] words, boolean[] visited, String begin, String target, int depth){
        if (begin.equals(target)) {
            min = Math.min(depth, min);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (canChange(begin, words[i]) && !visited[i]){ // 바꿀 수 있고, 방문하지 않았다면
                visited[i] = true;
                DFS(words, visited, words[i], target,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean canChange(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
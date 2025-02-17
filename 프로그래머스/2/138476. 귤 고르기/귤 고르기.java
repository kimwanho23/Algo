import java.util.*;

class Solution {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int current = 0;

        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        while (!pq.isEmpty()) {
            current += pq.poll();
            answer++;
            if (current >= k) break;
        }

        return answer;
    }
}
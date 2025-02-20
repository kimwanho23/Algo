import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int s1 = pq.poll();
            if (s1 >= K)
                return answer;

            if (pq.isEmpty()) return -1;

            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            answer++;
        }
        return -1;

    }
}
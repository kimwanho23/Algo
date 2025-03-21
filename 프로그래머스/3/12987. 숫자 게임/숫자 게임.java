import java.util.*;

class Solution {
       public static int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> pqA = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Integer> dequeB = new LinkedList<>();
        for (int i : A) {
            pqA.add(i);
        }

        Arrays.sort(B);
        for (int i : B) {
            dequeB.add(i);
        }

        while (!dequeB.isEmpty()){
            if (pqA.peek() < dequeB.peekLast()) {
                pqA.poll();
                dequeB.pollLast();
                answer++;
            } else {
                pqA.poll();
                dequeB.pollFirst();
            }
        }

        System.out.println(answer);
        return answer;
    }
}
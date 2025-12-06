import java.util.*;

class Solution {
    public static int calculateTime(String time){
        String[] t = time.split(":");
        return Integer.parseInt( t[0]) * 60 + Integer.parseInt( t[1]);
    }
    public static int solution(String[][] book_time) {
        int answer = 0; // 객실 수
        Arrays.sort(book_time, Comparator.comparing(time -> time[0])); // 정렬

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < book_time.length; i++) {
            int startTotal = calculateTime(book_time[i][0]);
            int endTotal = calculateTime(book_time[i][1]) + 10;

            while (!q.isEmpty() && q.peek() <= startTotal) {
                q.poll();
            }
            q.offer(endTotal);
            answer = Math.max(answer, q.size());
        }
        System.out.println(answer);
        return answer;
    }
}
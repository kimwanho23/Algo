import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위 큐 선언
        int cur = 0;
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]); // 현재 라운드 적 수
            cur += enemy[i]; // 현재 큐에 들어있는 적 수
            answer++; //일단 막은걸로 침
            if (cur > n) { // 못 막는 수
                if (k > 0){ // 방어권이 있다면
                    int a = pq.poll();
                    cur -= a; // 최대 병사 라운드 막음
                    k--; // 방어권 소비
                } else { // 없으면
                    answer--;  //못막은걸로 하고
                    break; // 종료
                }
            }
        }
        
        return answer;
    }
}
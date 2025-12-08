import java.util.*;

class Solution {
    public static int solution(int[] order) {
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        // 메인 벨트에서 상자 도착
        for (int box = 1; box <= order.length; box++) {
            stack.push(box);

            while (!stack.isEmpty() && stack.peek() == order[cnt]) {
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
    
}
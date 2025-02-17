import java.util.*;

class Solution {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int current = 0;

        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.values());

        keySet.sort(Collections.reverseOrder());

        for (Integer integer : keySet) {
            current += integer;
            answer++;
            if (k <= current) break;
        }

        return answer;
    }
}
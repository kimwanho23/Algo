import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        if (isZero(map)) 
            answer++;

        
        for (int i = 10; i < discount.length; i++) {
            String leftItem = discount[i - 10];
            if (map.containsKey(leftItem)) {
                map.put(leftItem, map.get(leftItem) + 1);
            }

            String rightItem = discount[i];
            if (map.containsKey(rightItem)) {
                map.put(rightItem, map.get(rightItem) - 1);
            }

            if (isZero(map)) {
            answer++;
            }
        }
        return answer;
    }
    
    public boolean isZero(HashMap<String, Integer> map) {
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
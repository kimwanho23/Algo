import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        int answer = 1;
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        answer--;

        return answer;
    }
}
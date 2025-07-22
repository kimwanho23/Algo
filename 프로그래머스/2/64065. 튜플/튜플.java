import java.util.*;

class Solution {
    public List<Integer> solution(String s) {

        s = s.replaceAll("[{}]", "");
        String[] numbers = s.split(",");

        // 2. 등장 횟수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (String numStr : numbers) {
            int num = Integer.parseInt(numStr);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 3. 등장 횟수 기준 정렬
        List<Integer> result = new ArrayList<>(countMap.keySet());
        result.sort((a, b) -> countMap.get(b) - countMap.get(a)); // 내림차순

        return result;
    }
}
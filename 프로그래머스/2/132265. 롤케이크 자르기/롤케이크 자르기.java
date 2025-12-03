import java.util.*;

class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> s1 = new HashMap<>();
        HashSet<Integer> s2 = new HashSet<>();

        for (int j : topping) {
            s1.put(j, s1.getOrDefault(j, 0) + 1);
        }

        int index = 0;
        while (index < topping.length) {
            s1.put(topping[index], s1.get(topping[index]) - 1);
            if (s1.get(topping[index]) == 0) {
                s1.remove(topping[index]);
            }
            s2.add(topping[index]);

            if (s1.size() == s2.size()){
                answer++;
            }
            if (s1.size() < s2.size()) {
                break;
            }
            index++;
        }
        return answer;
    }
}
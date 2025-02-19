import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
public static int[] solution(int[] progresses, int[] speeds) {
    List<Integer> result = new ArrayList<>();

    int days = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
    int count = 1;

    for (int i = 1; i < progresses.length; i++) {
        int nextDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

        if (nextDays <= days) {
            count++; 
        } else {
            result.add(count);
            count = 1; 
            days = nextDays;
        }
    }
    result.add(count);

    return result.stream().mapToInt(i -> i).toArray();
}
}
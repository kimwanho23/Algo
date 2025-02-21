import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};
    
    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        DFS("", 0);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    static void DFS(String str, int len) {
        list.add(str);
        if (len == 5) return;
        for (String word : words) {
            DFS(str + word, len + 1);
        }
    }
}
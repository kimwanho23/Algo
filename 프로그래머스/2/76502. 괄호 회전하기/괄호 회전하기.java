import java.util.Stack;

class Solution {
    public static int solution(String s) {
        int count = 0;
        //0 1 2 3 4 5, 1 2 3 4 5 0, 2 3 4 5 0 1, 3 4 5 0 1 2 , 4 5 0 1 2 3, 5 0 1 2 3 4

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < i + s.length(); j++) {
                char current = s.charAt(j % s.length()); // 현재 문자열
                if (stack.isEmpty()) {
                    stack.add(current);
                } else if ((current == ')' && stack.peek() == '(') ||
                        (current == '}' && stack.peek() == '{') ||
                        (current == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    stack.add(current);
                }
            }
            if (stack.isEmpty()) count++;
        }
        return count;
    }
}
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        
        while (storey != 0) {
            int m = storey % 10; // 나머지
            int next = (storey / 10) % 10;
            if (m > 5) {
                storey += 10 - m;
                answer += 10 - m;
            } else if (m < 5) {
                storey -= m;
                answer += m;
            } else {
                if (next >= 5){
                    storey += 10 - m;
                answer += 10 - m;
                } else {
                    storey -= m;
                answer += m;
                }
            }
            storey /= 10;
        }
        
        return answer;
    }
}
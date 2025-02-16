class Solution {
    public static int solution(int n) {
        String str1 = Integer.toBinaryString(n);
        int length1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '1') {
                length1++;
            }
        }
    //    System.out.println(length1);

        int answer = n + 1;
        while (answer != 1000000) {
            String str2 = Integer.toBinaryString(answer);
            int length2 = 0;
            for (int i = 0; i < str2.length(); i++) {
                if (str2.charAt(i) == '1') {
                    length2++;
                }
            }
         //   System.out.println(length2);

            if (length2 == length1)
                break;
            answer++;
        }
    //    System.out.println(answer);
        return answer;
    }
}
import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int count = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < length; i++) {
            count += A[i] * B[(length - 1) - i];
        }
        return count;
    }
}
import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long i=0; i<=d; i+=k) {
            long dd = (long) d * d;
            long ii = (long) i * i;
            
            int max = (int) Math.sqrt(dd - ii);
            
            answer += (max / k) + 1;
        }
        
        return answer;
    }
}
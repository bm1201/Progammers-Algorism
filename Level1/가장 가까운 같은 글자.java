import java.util.*;

class Solution {
    public int[] solution(String s) {
    	int[] answer = new int[s.length()];
    	
    	answer[0] = -1;
    	
        for(int i=0; i<s.length(); i++){
        	int result = s.lastIndexOf(s.substring(i, i+1), i-1);
        	
        	if(result != -1) {
        		answer[i] = i-result;
        	}else {
        		answer[i] = result;
        	}
        }
        
        return answer;
    }
}
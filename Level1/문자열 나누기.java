import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        ArrayList<String> answerList = new ArrayList<String>();
        
        int sameCnt = 0;
        int differntCnt = 0;
        int lastIndex = 0;

        for(int i=0; i<s.length(); i=i++){
            char stdChar = s.charAt(i);
            
            for(int j=0; j<s.length(); j++){
                if(stdChar == s.charAt(j)){
                    sameCnt++;
                }else{
                    differntCnt++;
                }
                
                if(sameCnt == differntCnt){
                    answerList.add(s.substring(i, j+1));
                    sameCnt = 0;
                    differntCnt = 0;
                    s = s.substring(j+1);
                    break;
                }else {
                	if(j == s.length()-1) {
                		answerList.add(s);
                        answer = answerList.size();
                        return answer;
                	}
                }
            }
        }
        
        answer = answerList.size();
        return answer;
    }
}
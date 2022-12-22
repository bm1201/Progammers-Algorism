import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> calcMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<tangerine.length ; i++){
            if(calcMap.get(tangerine[i]) == null){
                calcMap.put(tangerine[i], 1);
            }else{
                calcMap.put(tangerine[i], calcMap.get(tangerine[i]) + 1);
            }
        }
        
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        
        for(int key : calcMap.keySet()){
            resultList.add(calcMap.get(key));
        }
        
        resultList.sort(Comparator.reverseOrder());
        
        int calcNum = 0;        
        
        for(int i=0; i<resultList.size(); i++){
            calcNum = calcNum + resultList.get(i);
            if(calcNum >= k){
                answer++;
                break;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}
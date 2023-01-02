/*
 * set 두개를 만들어서 풀려고 시도하였지만 시간초과 발생
 * set, HashMap 동시에 사용해서 해결
 */

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> older = new HashMap<>();
        HashSet<Integer> younger = new HashSet<Integer>();
        
        for(int i=0; i<topping.length; i++){
            //형한테 우선 모든 토핑추가
            older.put(topping[i], older.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int j=0; j<topping.length; j++){
            //동생에게 토핑추가
            younger.add(topping[j]);
            
            //동생에게 준 토핑은 지우기
            older.put(topping[j], older.get(topping[j]) - 1);
            if(older.get(topping[j]) == 0){
                older.remove(topping[j]);
            }
            
            if(older.size() == younger.size()){
                answer++;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> subBelt = new Stack<Integer>();
        int i=0;
        
        for(int box=1; box<=order.length; box++) {//for문을 메인벨트라고 생각
        	if(box != order[i]) {
        		//원하는 상자가 아닐경우
        		subBelt.push(box);
        		continue;
        	}else {
        		answer++;
        		i++;
        	}
        	
        	// 보조 벨트에 다음 상자가 있는지 확인
            while (true){
            	if(subBelt.size() != 0 && subBelt.peek() == order[i]) {
            		subBelt.pop();
                    answer++;
                    i++;
            	}else {
                	break;
            	}
            }
        }
        
        return answer;
    }
}
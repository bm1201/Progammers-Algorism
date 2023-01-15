import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
            
        for(int i=0; i<=t.length()-p.length(); i++){
            if(Long.parseLong(t.substring(i, p.length()+i)) <= Long.parseLong(p)){
                answer++;
            }    
        }

        return answer;
    }
}

// Integer.parseInt를 사용하지 않은 이유
// p의 제한사항으로 최대길이가 18자리 라고 주어졌는데, 이 경우 Integer의 최댓값인 약21억(10자리)을 초과하기 때문에
// 더큰 정수형 데이터인 Long클래스의 parseLong을 사용
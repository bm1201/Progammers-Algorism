class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true){
            int share = 0;
            int rest = 0;
            
            if(n/a > 0){
                share = n/a;
                rest = n%a;
                answer = answer + (b*share);
                n = (b*share) + rest;
            }else{
                break;
            }
        }
        
        return answer;
    }
}
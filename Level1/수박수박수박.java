class Solution {
    public String solution(int n) {
        String answer = "";

        if(n%2 == 0){
            //짝수인 경우
            int i = n/2;

            while(i>0){
                answer = answer + "수박";
                i--;
            }
        }else{
            //홀수인 경우
            int i = n/2;

            while(i>0){
                answer = answer + "수박";
                i--;
            }

            answer = answer + "수";
        }

        return answer;
    }
}
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(i == numbers.length-1){
                answer[i] = -1;
            }
            
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }else{
                    if(j == numbers.length-1){
                        answer[i] = -1;
                    }
                }
            }
        }
        
        return answer;
    }
}
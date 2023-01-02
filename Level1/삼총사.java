class Solution {
    int[] numArr;
    int[] temp = new int[3];
    int maxDepth = 0;
    int answer = 0;
    
    public int solution(int[] number) {
        
        maxDepth = number.length;
        numArr = number;
        DFS(0,0);
        
        return answer;
    }
    
    public void DFS(int idx, int depth){
        if(depth == 3){
            int sum = 0;
            for(int i = 0 ; i < 3; i++){
                sum += temp[i];   
            }
            if(sum == 0){
                answer++;
            }
            return;
        }
        
        for(int i = idx; i < maxDepth; i++){
            temp[depth] = numArr[i];
            DFS(i+1, depth + 1);
        }
    }
}
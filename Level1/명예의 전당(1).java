import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> scoreRank = new PriorityQueue<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        for(int i=0; i<score.length; i++){
            if(i <= k-1){
                scoreRank.add(score[i]);
                answerList.add(scoreRank.peek());
            }else{
                if(score[i] > scoreRank.peek()){
                    scoreRank.add(score[i]);
                    scoreRank.remove();
                    answerList.add(scoreRank.peek());
                }else {
                	answerList.add(scoreRank.peek());
                }
            }
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
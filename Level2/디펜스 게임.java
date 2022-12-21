import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int life = n;
        
        for(int i=0; i<enemy.length; i++){
            life = life - enemy[i];
            priorityQueue.add(enemy[i]);
            
            if(life < 0){
                if(k > 0){
                    life = life + priorityQueue.poll();
                    k--;
                }else{
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int totalPower = 0;
        
        for(int i=1; i<number+1; i++){
            int count = 0;

            for(int j=1; j<=Math.sqrt(i); j++){
                if(i%j == 0){
                    if(i/j == j){
                        count++;
                    }else{
                        count += 2;
                    }
                }
            }
            
            System.out.print(count + " ");
            
            if(count > limit){
                totalPower += power;
            }else{
                totalPower += count;
            }
        }
        
        return totalPower;
    }
}
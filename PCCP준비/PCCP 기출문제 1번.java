//30분 걸림

/**
 * 첫번째 시도 소스 - 14번 테스트 케이스만 실패로 나옴
 * 실패 이유 : 연속성공을 한 경우에도 연속성공을 초기화 해줘야하는데 해당 부분을 처리하지 않음
*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
    
        int time = 0; //시간
        int success = 0; //연속성공여부
        int maxHealth = health; //최대체력
        int curHealth = health; //현재체력
        int maxAtkIdx = attacks.length-1; //공격 MaxIdx
        int curAtkIdx = 0; //공격 현재 Idx
        
        if(maxAtkIdx == 0){
            //몬스터가 공격을 안하는 경우
            return curHealth;
        }
        
        while(true){
            time++;
            
            //공격 여부 확인
            if(time == attacks[curAtkIdx][0]){
                //공격하는 경우
                success = 0;// 연속성공 초기화
                curHealth = curHealth - attacks[curAtkIdx][1];
                if(curHealth <= 0){
                    //캐릭터가 죽는 경우
                    return -1;
                }else{
                    //공격이 종료되는 경우
                    if(curAtkIdx == maxAtkIdx){
                        return curHealth;
                    }
                    curAtkIdx++;
                }
            }else{
                //공격 안하는 경우
                success++;
                if(success == bandage[0]){
                    //연속성공을 한 경우
                    curHealth = curHealth + bandage[1] + bandage[2];
                    if(curHealth >= maxHealth){
                        //최대 체력을 넘어가는 경우 최대체력으로 고정
                        curHealth = maxHealth;
                    }
                }else{
                    curHealth = curHealth + bandage[1];
                    if(curHealth >= maxHealth){
                        //최대 체력을 넘어가는 경우 최대체력으로 고정
                        curHealth = maxHealth;
                    }
                }
            }
        }
    }
}

/**
 * 두번째 시도 소스 - 성공
 */
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
    
        int time = 0; //시간
        int success = 0; //연속성공여부
        int maxHealth = health; //최대체력
        int curHealth = health; //현재체력
        int maxAtkIdx = attacks.length-1; //공격 MaxIdx
        int curAtkIdx = 0; //공격 현재 Idx
        
        if(maxAtkIdx == 0){
            //몬스터가 공격을 안하는 경우
            return curHealth;
        }
        
        while(true){
            time++;
            
            //공격 여부 확인
            if(time == attacks[curAtkIdx][0]){
                //공격하는 경우
                success = 0;// 연속성공 초기화
                curHealth = curHealth - attacks[curAtkIdx][1];
                if(curHealth <= 0){
                    //캐릭터가 죽는 경우
                    return -1;
                }else{
                    //공격이 종료되는 경우
                    if(curAtkIdx == maxAtkIdx){
                        return curHealth;
                    }
                    curAtkIdx++;
                }
            }else{
                //공격 안하는 경우
                success++;
                if(success == bandage[0]){
                    //연속성공을 한 경우
                    success = 0;//연속성공 초기화
                    curHealth = curHealth + bandage[1] + bandage[2];
                    if(curHealth >= maxHealth){
                        //최대 체력을 넘어가는 경우 최대체력으로 고정
                        curHealth = maxHealth;
                    }
                }else{
                    curHealth = curHealth + bandage[1];
                    if(curHealth >= maxHealth){
                        //최대 체력을 넘어가는 경우 최대체력으로 고정
                        curHealth = maxHealth;
                    }
                }
            }
        }
    }
}
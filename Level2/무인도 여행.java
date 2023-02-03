import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        //지도세팅
        String [][] map = new String[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                map[i][j] = maps[i].substring(j,j+1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int row=0; row<map.length; row++){
            for(int col=0; col<map[row].length; col++){
                int result = searchMap(map, visit, row, col);
                if(result > 0) {
                	list.add(result);
                }
            }
        }
        
        Collections.sort(list);
        
        if(list.isEmpty()) {
        	int[] answer = {-1};
        	return answer;
        }else {
        	int[] answer = new int[list.size()];
        	
        	for(int i=0; i<list.size(); i++) {
        		answer[i] = list.get(i);
        	}

        	return answer;
        }
    }
    
    public int searchMap(String[][] map, boolean[][] visit, int row, int col){
        if (row < 0 || col < 0 || row == map.length || col == map[row].length){
            return 0;
        }

        //이미 방문했거나 바다인 경우
        if(visit[row][col] || map[row][col].equals("X")){
            return 0;
        }else{
            visit[row][col] = true;
            int result = Integer.parseInt(map[row][col]);

            result += searchMap(map, visit, row + 1, col);
            result += searchMap(map, visit, row - 1, col);
            result += searchMap(map, visit, row, col + 1);
            result += searchMap(map, visit, row, col - 1);

            return result;
        }
    }
}

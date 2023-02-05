import java.util.*;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        HashMap<String, String> termsMap = new HashMap<String, String>();
        
        for(int i=0; i<terms.length; i++){
            termsMap.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        for(int i=0; i<privacies.length; i++){
            String checkDate = calcDate(termsMap, privacies[i].split(" ")[0], privacies[i].split(" ")[1]);
            
            boolean checkRemove = compareDate(today, checkDate);
            
            if(checkRemove){
            	answerList.add(i+1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public String calcDate(HashMap<String, String> termsMap, String date, String type){
        int term = Integer.parseInt(termsMap.get(type));
        
        int tempYear  = Integer.parseInt(date.split("[.]")[0]);
        int tempMonth = Integer.parseInt(date.split("[.]")[1]);
        
        String calcYear = null;
        String calcMonth = null;
        String calcDate  = date.split("[.]")[2];
        
        
        if((tempMonth + term) > 12){
        	//연도가 넘어가는 경우
        	if((tempMonth + term)%12 == 0) {
        		tempYear = tempYear + ((tempMonth + term)/12 - 1);
        		tempMonth = 12;
        	}else {
        		tempYear = tempYear + (tempMonth + term)/12;
        		tempMonth = (tempMonth + term)%12;
        	}
        	
        	calcYear =  Integer.toString(tempYear);
            
            if(tempMonth < 10) {
            	calcMonth = "0" + Integer.toString(tempMonth);
            }else {
            	calcMonth = Integer.toString(tempMonth);
            }
            
            return calcYear + "." + calcMonth + "." + calcDate;
        }else{
        	calcYear = Integer.toString(tempYear);
            tempMonth = tempMonth + term;
            
            if(tempMonth < 10) {
            	calcMonth = "0" + Integer.toString(tempMonth);
            }else {
            	calcMonth = Integer.toString(tempMonth);
            }
            
            return calcYear + "." + calcMonth + "." + calcDate;
        }
    }
    
    public boolean compareDate(String today, String checkDate) {
    	
        int todayYear  = Integer.parseInt(today.split("[.]")[0]);
        int todayMonth = Integer.parseInt(today.split("[.]")[1]);
        int todayDate = Integer.parseInt(today.split("[.]")[2]);

        int checkYear  = Integer.parseInt(checkDate.split("[.]")[0]);
        int checkMonth = Integer.parseInt(checkDate.split("[.]")[1]);
        int checkDate1 = Integer.parseInt(checkDate.split("[.]")[2]);
    	
        if(todayYear - checkYear > 0){
            return true;
        }else if(todayYear - checkYear == 0 && todayMonth - checkMonth > 0){
            return true;
        }else if(todayYear - checkYear == 0 && todayMonth - checkMonth == 0 && todayDate - checkDate1 >= 0){
            return true;
        }else{
            return false;
        }
    }
}
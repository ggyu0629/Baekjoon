import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        answer = my_string.substring(0,s) + overwrite_string;
        
        if(answer.length() != my_string.length())
            answer = answer + my_string.substring(answer.length());
        
        return answer;
    }
}
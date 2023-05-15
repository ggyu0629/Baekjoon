import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<computers.length; i++) {
            if(visit[i]){
                continue;
            }

            q.add(computers[i]);
            visit[i] = true;

            while(!q.isEmpty()) {
                int[] temp = q.poll();

                for(int j=0; j<temp.length; j++) {
                    if(visit[j])
                        continue;
                
                    if(temp[j] == 0)
                        continue;

                    q.add(computers[j]);
                    visit[j] = true;
                }
            }
            answer++;
        }

        return answer;
    }
}
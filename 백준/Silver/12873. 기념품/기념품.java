import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //기념품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();
        
        for (int i = 1; i <= n ; i++) {
            que.add(i);         
        }
        
        long round = 1;
        long cnt = 1;
        
        while(que.size() != 1){
            cnt = (long) Math.pow(round, 3); 
            
            cnt = cnt % que.size();
            
            if( cnt == 0)
                cnt = que.size();

            for (int i = 0; i < cnt - 1; i++) {
                que.add(que.poll());
            }
            round++;
            que.poll();
        }
        System.out.println(que.peek());
    }
}
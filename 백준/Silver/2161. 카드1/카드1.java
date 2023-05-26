import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        int N = sc.nextInt();
        for(int i = 1;i<=N;i++)//큐 초기화
            que.offer(i);

        while (true){
            if(que.size() == 1)
                break;
            System.out.print(que.poll()+" ");
            que.offer(que.poll());
        }
        System.out.print(que.poll());

    }
}
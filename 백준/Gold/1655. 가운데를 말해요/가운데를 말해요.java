import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    //가운데를 말해요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(min.size() == max.size())
                max.add(num);
            else
                min.add(num);

            if(!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()){
                int minPoll = min.poll();
                min.add(max.poll());
                max.add(minPoll);
            }

            sb.append(max.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
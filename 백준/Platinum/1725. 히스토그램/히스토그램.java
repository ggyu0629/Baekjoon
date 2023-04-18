import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    //히스토그램

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        int[] arr = new int[N + 2];
        int result =0;

        for(int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=1; i<=N+1 ; i++) {
            while(!s.isEmpty()) {
                int top = s.peek();

                if(arr[top] <= arr[i])
                    break;
                s.pop();

                result = Math.max(result, arr[top]*(i-s.peek()-1));
            }
            s.push(i);
        }

        System.out.println(result);
    }
}
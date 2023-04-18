import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    //히스토그램에서 가장 큰 사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0)
                break;

            long[] arr = new long[N + 2];
            long result =0;

            for(int i=1; i<N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
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
}
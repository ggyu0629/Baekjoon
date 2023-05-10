import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //회의실 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i] = p;
        }

        dp[0] = arr[0];
        if(n <= 1) {
            System.out.println(arr[0]);
            return;
        }
        dp[1] = Math.max(arr[0],arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i],dp[i-1]);
        }

        System.out.println(dp[n-1]);

    }


}
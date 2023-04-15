import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //가장 긴 증가하는 부분수열 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for(int s : dp){
            if(res < s)
                res = s;
        }

        sb.append(res).append("\n");
        String s = "";

        for (int i = n-1; i >= 0 ; i--) {
            if(dp[i] == res){
                s = arr[i]+" "+s;
                res--;
            }
        }

        sb.append(s);
        System.out.println(sb);

    }
}
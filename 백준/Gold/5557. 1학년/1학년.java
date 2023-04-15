import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1학년
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long [][] dp = new long[n][21];


        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < 21; j++) {
                if(dp[i][j] != 0){
                    int p = j+arr[i+1];
                    int m = j-arr[i+1];

                    if(m>=0)
                        dp[i+1][m] += dp[i][j];
                    if(p<21)
                        dp[i+1][p] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);


    }
}
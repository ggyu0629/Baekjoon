import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //BABBA
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        //A     B       BA      BAB     BABBA   BABBABAB BABBABABBABBA
        //1 0   0 1     1 1     1 2     2 3     5 3      8 5
        //피보나치
        int[][] dp = new int[46][2];

        dp[2][0] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= k; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        System.out.print(dp[k][0] + " " + dp[k][1]);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //가장 큰 정사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        int res = 0;

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 1 ; i <= m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(map[i-1][j-1] == 1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        System.out.println(res*res);


    }
}
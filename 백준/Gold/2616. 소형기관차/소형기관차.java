;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //소형기관차
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        int[][] dp = new int[4][n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        for (int i = 1; i < 4; i++) {
            for (int j = i*m; j <=n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-m] + sum[j] - sum[j-m]);
            }
        }

        System.out.println(dp[3][n]);
    }
}
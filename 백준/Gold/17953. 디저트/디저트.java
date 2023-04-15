import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //디저트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dessert = new int[M][N];
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                dessert[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dessert.length; i++) {
            dp[i][0] = dessert[i][0];
        }

        for (int day = 1; day < N; day++) {
            for (int type = 0; type < M; type++) {
                for (int eachType = 0; eachType < M; eachType++) {
                    if (eachType == type)
                        dp[type][day] = Math.max(dp[type][day], dp[eachType][day - 1] + dessert[type][day] / 2);
                    else
                        dp[type][day] = Math.max(dp[type][day], dp[eachType][day - 1] + dessert[type][day]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++)
            answer = Math.max(answer, dp[i][N - 1]);

        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //내리막길
    static int m, n;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] DR = { -1, 0, 1, 0 };
    static int[] DC = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m][n];
        dp[m-1][n-1] = 1;

        dfs(0, 0);

        int h = dp[0][0];
        System.out.println(h);
    }
    static void dfs(int row, int col) {
        if (row == m-1  && col == n-1 )
            return;

        if (visited[row][col])
            return;

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = row + DR[i];
            int nextC = col + DC[i];

            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && map[row][col] > map[nextR][nextC]) {
                if (dp[nextR][nextC] != 0){
                    dp[row][col] += dp[nextR][nextC];
                }else{
                    dfs(nextR, nextC);
                    dp[row][col] += dp[nextR][nextC];
                }
            }


        }
    }

}
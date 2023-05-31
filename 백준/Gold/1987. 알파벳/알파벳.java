import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //알파벳
    static char[][] map;
    static boolean[] vis;
    static int r;
    static int c;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int res = 0;
    static int startR = 0, startC = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        vis = new boolean[26];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        vis[map[0][0] - 'A'] = true;
        dfs(0,0, 1);

        System.out.println(res);

    }

    static void dfs(int tr, int tc, int depth){

        res = Math.max(res, depth);

        for (int i = 0; i < 4; i++)
        {
            int nextR = tr + dr[i];
            int nextC = tc + dc[i];

            if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c)
            {
                if (!vis[map[nextR][nextC] - 'A'])
                {
                    vis[map[nextR][nextC] - 'A'] = true;
                    dfs(nextR, nextC, depth+1);
                    vis[map[nextR][nextC] - 'A'] = false;
                }
            }
        }
    }
}
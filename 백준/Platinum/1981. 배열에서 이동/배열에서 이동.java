import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //배열에서 이동

    static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[][] map;
    static int n, min, max, res;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] vis;
    static Queue<Pos> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }
        bs();
        System.out.println(res);
    }

    public static void bs(){

        int start = 0;
        int end = max - min;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (bfs(mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
    }

    public static boolean bfs(int value){

        for(int k = min; k+value<=max ;k++){
            int start = k;
            int end = start + value;

            if(start > map[0][0] || end < map[0][0])
                continue;

            q = new LinkedList<>();
            q.add(new Pos(0,0));
            vis = new boolean[n][n];
            vis[0][0] = true;

            while(!q.isEmpty()){

                Pos cur = q.poll();

                if(cur.r == n-1 && cur.c == n-1){
                    return true;
                }

                for(int i = 0;i<4;i++){
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n)
                        continue;

                    if(vis[nextR][nextC])
                        continue;

                    if(start > map[nextR][nextC] || end < map[nextR][nextC])
                        continue;

                    q.add(new Pos(nextR, nextC));
                    vis[nextR][nextC] = true;

                }
            }
        }
        return false;
    }
}
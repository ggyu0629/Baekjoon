import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //연구소

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    static int[][] map;
    static int[][] map2;
    static int n;
    static int m;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        map2 = new int[n][m];
        res = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map2 = map;

        upWall(0);
        System.out.println(res);
    }
    static void bfs() {
        Queue<Pos> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 2) {
                    q.add(new Pos(i,j));
                }
            }
        }

        map2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            map2[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Pos cur = q.poll();

            for(int i=0; i<4; i++) {
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];

                if(0<=nextR && nextR<n && 0<=nextC && nextC<m) {
                    if(map2[nextR][nextC] == 0) {
                        q.add(new Pos(nextR,nextC));
                        map2[nextR][nextC] = 2;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map2[i][j] == 0)
                    cnt++;
            }
        }
        res = Math.max(res, cnt);
    }
    static void upWall(int wallCnt) {

        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    upWall(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static class Pos{
        int row;
        int col;

        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
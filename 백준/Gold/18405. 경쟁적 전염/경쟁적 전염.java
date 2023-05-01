import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int r, c, vn, time;

        public Pos(int r, int c, int vn, int time){
            this.r = r;
            this.c = c;
            this.vn = vn;
            this.time = time;
        }
    }

    static int n, k ;
    static int s, x ,y ;
    static int[][] board;
    static ArrayList<Pos> list = new ArrayList<>();
    static Queue<Pos> que = new LinkedList<>();
    static boolean[][] vis;
    static int[] DR = {1,0,-1,0};
    static int[] DC = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        vis = new boolean[n][n];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0)
                    list.add(new Pos(i,j,board[i][j],0));
            }
        }

        Collections.sort(list, new Comparator<Pos>() {
            public int compare(Pos o1, Pos o2) {
                return o1.vn - o2.vn;
            }
        });
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        que.addAll(list);

        bfs();

        System.out.println(board[x-1][y-1]);
    }

    public static void bfs(){


        while(!que.isEmpty()){
            Pos cur = que.poll();

            if(cur.time == s){
                return;
            }


            for(int i = 0;i<4;i++){
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if (nextR >= 0  && nextR < n && nextC >= 0 && nextC < n) {
                    if (board[nextR][nextC] == 0) {
                        board[nextR][nextC] = cur.vn;
                        que.add(new Pos(nextR, nextC, cur.vn, cur.time + 1));
                    }
                }
            }
        }
    }
}

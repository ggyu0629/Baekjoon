import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Pos{
        int r, c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Pos> que = new LinkedList<>();
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] vis;
    static int n;
    static int m;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];

        for(int i = 0;i<n;i++){//입력받기
            for(int j = 0;j<m;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1){
                    que.add(new Pos(i,j));
                }
            }
        }

        bfs();



    }

    public static void bfs(){
        while (!que.isEmpty()){

            Pos cur = que.poll();
            for(int i = 0;i<4;i++){
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if(nextR<0 || nextR>= n||nextC <0|| nextC>=m){//BFS 조건
                    continue;
                }

                if(board[nextR][nextC] == 0){
                    que.add(new Pos(nextR,nextC));
                    board[nextR][nextC] = board[cur.r][cur.c] + 1;
                }

            }
        }
        tomato();
    }

    public static void tomato(){

        for(int i = 0;i<n;i++){//입력받기
            for(int j = 0;j<m;j++){
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }else{
                    cnt = Math.max(board[i][j],cnt);
                }
            }
        }
        System.out.println(cnt - 1);

    }
}

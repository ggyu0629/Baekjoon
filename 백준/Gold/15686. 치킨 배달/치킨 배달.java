import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //치킨 배달

    static class Pos{
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int n, m, res;
    static List<Pos> chicken;
    static List<Pos> house;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 2){
                    chicken.add(new Pos(i, j));
                }else if(tmp == 1){
                    house.add(new Pos(i,j));
                }
            }
        }

        vis = new boolean[chicken.size()];
        res = Integer.MAX_VALUE;
        dfs(0,0);

        System.out.println(res);
    }

    public static void dfs(int idx,int depth){
        if(depth == m){
            int distance = 0;

            for (Pos pos : house) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (vis[j])
                        tmp = Math.min(tmp, minDistance(pos, chicken.get(j)));
                }
                distance += tmp;
            }

            res = Math.min(res, distance);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            vis[i] = true;
            dfs(i + 1, depth + 1);
            vis[i] = false;
        }
    }

    public static int minDistance(Pos house, Pos chicken){
        return Math.abs(house.r - chicken.r)
                + Math.abs(house.c - chicken.c);
    }

}
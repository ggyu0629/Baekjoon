import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //하늘에서 정의가 빗발친다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        num[] arr = new num[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            double d = Math.sqrt((Math.pow(x,2) + Math.pow(y,2))) / v;

            arr[i] = new num(d, i+1);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i].index).append("\n");
        }

        System.out.println(sb);
    }

    static class num implements Comparable<num>{
        double d;
        int index;

        public num (double d, int index){
            this.d = d;
            this.index = index;
        }

        @Override
        public int compareTo(num o){
            if(this.d == o.d){
                return Math.min(this.index, o.index);
            }else if(this.d > o.d){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
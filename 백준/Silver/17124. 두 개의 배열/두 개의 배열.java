import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //두 개의 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        long[] a;
        long[] b;
        long[] c;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            a = new long[n];
            b = new long[m];
            c = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);


            for (int j = 0; j < n; j++) {
                int left = 0;
                int right = m-1;
                long abs = Integer.MAX_VALUE;

                while(left<=right) {
                    int mid = (left+right)/2;

                    if(Math.abs(a[j] - b[mid]) < Math.abs(abs)){
                        c[j] = b[mid];
                        abs = a[j] - b[mid];
                    }else if(Math.abs(a[j]- b[mid]) == Math.abs(abs) && b[mid] < c[j]){
                        c[j] = b[mid];
                    }

                    if(a[j] == b[mid])
                        break;

                    if(a[j] > b[mid])
                        left = mid + 1;
                    else if(a[j] < b[mid] )
                        right = mid - 1;
                }
            }
            long res = 0;

            for(long s : c)
               res += s;

            System.out.println(res);

        }
    }

}
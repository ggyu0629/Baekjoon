import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //같은 나머지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i] - arr[i-1];
        }

        int res = arr[0];

        for (int i = 1; i < n-1; i++) {
            res = gcd(res,arr[i]);
        }

        System.out.println(res);

    }

    public static int gcd(int n1, int n2){
        int temp = 0;

        while(true){
            if(n1 > n2){
                temp = n1;
                n1 = n2;
                n2 = temp;
            }

            if(n1 == 0)
                return n2;

            if(n2 % n1 == 0)
                return n1;
            else
                n2 = n2 % n1;
        }

    }
}
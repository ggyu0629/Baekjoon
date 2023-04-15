import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //두 용액
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int start = 0;
        int end = n-1;
        int[] res = {0,0};

        int num = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);



        while (start < end) {
            int tmpDiff = Math.abs(arr[start] + arr[end]);
            if (tmpDiff < num) {
                num = tmpDiff;
                res[0] = arr[start];
                res[1] = arr[end];
            }
            if (arr[start] + arr[end] > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(res[0] + " " + res[1]);


    }
}
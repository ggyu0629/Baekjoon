import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 증가하는 부분 수열
    static int[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        LIS = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //----------------------------------

        int j = 0;

        for (int i = 0; i < n; i++) {
            if(LIS[j] < arr[i]){
                LIS[j+1] = arr[i];
                j += 1;
            }else{
                int pos = binarySearch(0, j, arr[i]);
                LIS[pos] = arr[i];
            }
        }
        System.out.println(j);

    }
    static int binarySearch(int left, int right, int target){
        int mid;

        while(left<right){
            mid = (left+right) / 2;

            if(LIS[mid] < target)
                left = mid+1;
            else
                right = mid;

        }
        return right;
    }
}
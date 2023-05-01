import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);;
        int count = 0;
        for(int k = 0; k<N;k++){
            long target = arr[k];
            int start = 0;
            int end = N-1;
            while(start < end){
                if(arr[start] + arr[end] == target){
                    if(start!=k&&end!=k){
                        count++;
                        break;
                    }else if(start == k)
                        start++;
                    else
                        end--;
                }else if(arr[start] + arr[end] <target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(count);

    }
}

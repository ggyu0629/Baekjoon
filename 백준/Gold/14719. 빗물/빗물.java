import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int result = 0;

        int[] arr = new int[M];
        int[] L_arr = new int[M];
        int[] R_arr = new int[M];

        for(int i = 0;i<M;i++){
            arr[i] = sc.nextInt();
        }
        int max = 0;

        for(int i = 0;i<M;i++){
            if(max <= arr[i]){
                max = arr[i];
                L_arr[i] = max;
            }
            L_arr[i] = max;
        }

        max=  0;
        for(int i = M-1;i>=0;i--){
            if(max <= arr[i]){
                max = arr[i];
                R_arr[i] = max;
            }
            R_arr[i]=max;
        }

        for(int i = 0;i<M;i++){
            L_arr[i] = Math.min(L_arr[i],R_arr[i]);
            result += Math.abs(arr[i] - L_arr[i]);
        }
        System.out.println(result);



    }
}

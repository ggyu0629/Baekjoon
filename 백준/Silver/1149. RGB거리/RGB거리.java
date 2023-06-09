import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][3];

        for(int i = 0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        for(int i =1;i<n;i++){
            arr[i][0]= arr[i][0] + Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1]= arr[i][1] + Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2]= arr[i][2] + Math.min(arr[i-1][0],arr[i-1][1]);
        }
        System.out.println(Math.min(Math.min(arr[n-1][0],arr[n-1][1]),arr[n-1][2]));
    }


}

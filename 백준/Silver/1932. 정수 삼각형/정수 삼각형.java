import java.util.Scanner;

public class Main {
    static int[][] arr = new int [500][500];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = n-1;i>0;i--){
            for(int j = 0;j<i;j++){
                arr[i-1][j] = arr[i-1][j]+ Math.max(arr[i][j],arr[i][j+1]);
            }

        }
        System.out.println(arr[0][0]);
    }
}


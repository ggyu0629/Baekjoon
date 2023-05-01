import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String [][] ladder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());//사람수
        int n = Integer.parseInt(br.readLine());//가로줄 수

        String[] resultString = br.readLine().split("");
        String[] startString = new String[k];

        ladder = new String[n][k-1];

        for(int i = 0 ; i < k ; i++){
            startString[i] = String.valueOf((char)('A' + i));
        }

        int checkPoint = 0;

        for(int i = 0;i<n;i++) {
            ladder[i] = br.readLine().split("");

            if(ladder[i][0].equals("?")){
                checkPoint = i;
            }
        }

        for(int i = 0;i<checkPoint;i++){
            for(int j = 0;j<k-1;j++){
                if(ladder[i][j].equals("-")){
                    String temp = startString[j];
                    startString[j] = startString[j+1];
                    startString[j+1] = temp;
                }
            }
        }



        for(int i = n-1;i>checkPoint;i--){
            for(int j = 0;j<k-1;j++){
                if(ladder[i][j].equals("-")){
                    String temp = resultString[j];
                    resultString[j] = resultString[j+1];
                    resultString[j+1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < k-1; i++){

            if(startString[i].equals(resultString[i])){
                sb.append("*");

            }

            else if(startString[i].equals(resultString[i+1]) || startString[i+1].equals(resultString[i])){
                sb.append("-");
                String tmp = startString[i];
                startString[i] = startString[i+1];
                startString[i+1] = tmp;

            }

            else{

                for(int j = 0 ; j < k-1 ; j++)
                    System.out.print("x");
                System.out.println();

                return;
            }
        }


        System.out.println(sb);

    }
}

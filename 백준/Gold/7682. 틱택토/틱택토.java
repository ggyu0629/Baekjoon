import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //틱택토

    static char[][] board = new char[3][3];

    static final String good = "valid";
    static final String bad = "invalid";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            if(s.equals("end"))
                break;

            int x = 0;
            int o = 0;

            for(int i = 0;i<3;i++){
                for (int j = 0; j < 3; j++) {
                    if(s.charAt(3*i+j) == 'X')
                        x++;
                    else if(s.charAt(3*i+j) == 'O')
                        o++;

                    board[i][j] = s.charAt(3*i+j);
                }
            }
            if(x + o == 9 && x - o == 1) {
                if(Bingo('X') && Bingo('O'))
                    sb.append(bad);
                else if(Bingo('O'))
                    sb.append(bad);
                else
                    sb.append(good);
            }else{
                if(Bingo('X') && Bingo('O'))
                    sb.append(bad);
                else if(Bingo('X') && x-o == 1)
                    sb.append(good);
                else if(Bingo('O') && x == o)
                    sb.append(good);
                else
                    sb.append(bad);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static boolean Bingo(char horse) {

        for(int i=0; i<3; i++) {
            int cnt = 0;

            for(int j=0; j<3; j++)
                if(board[i][j]==horse) cnt++;

            if(cnt==3)
                return true;
        }

        for(int j=0; j<3; j++) {
            int cnt = 0;

            for(int i=0; i<3; i++)
                if(board[i][j]==horse) cnt++;

            if(cnt==3)
                return true;
        }

        if(board[0][0] == horse && board[1][1] == horse && board[2][2] == horse)
            return true;
        return board[0][2] == horse && board[1][1] == horse && board[2][0] == horse;
    }
}
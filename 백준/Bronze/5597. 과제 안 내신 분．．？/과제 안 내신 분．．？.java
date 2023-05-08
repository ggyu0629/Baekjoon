import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30";

        for (int i = 0; i < 28; i++) {
            s = s.replaceFirst(br.readLine(),"");
        }

        s = s.trim();

        sb.append(s.charAt(0));

        if(s.charAt(1) != ' ') {
            sb.append(s.charAt(1));
        }
        sb.append("\n");

        s = s.substring(2);
        s = s.trim();
        sb.append(s);

        System.out.println(sb);
    }
}
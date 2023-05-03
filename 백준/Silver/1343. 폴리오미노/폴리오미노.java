import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //폴리오미노
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        s = s.replace("XXXX","AAAA");

        s = s.replace("XX","BB");

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'X'){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(s);

    }
}
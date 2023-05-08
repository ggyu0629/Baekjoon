import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30";
        Map<String, String> res = new HashMap<>();

        for (int i = 0; i < 28; i++) {
            s = s.replaceFirst(sc.nextLine(),"");
        }

        s = s.trim();

        System.out.print(s.charAt(0));

        if(s.charAt(1) != ' ') {
            System.out.print(s.charAt(1));
        }
        System.out.println();

        s = s.substring(2);
        s = s.trim();
        System.out.println(s);
    }
}
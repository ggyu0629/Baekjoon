import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if(tmp == '(')
                    st.push(tmp);
                else if(st.empty()) {
                    st.push('3');
                    break;
                }
                else
                    st.pop();

            }

            if(st.empty())
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7272_안경이없어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            boolean flag = true;
            for(int i=0; i<a.length(); i++){
                if(a.length() != b.length()){
                    System.out.println("#" + tc + " DIFF");
                    flag = false;
                    break;
                }
                if(!check(a.charAt(i)).equals(check(b.charAt(i)))){
                    System.out.println("#" + tc + " DIFF");
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("#" + tc + " SAME");
            }
        }
    }

    public static String check(char a){
        char[] zero = {'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] one = {'A', 'D', 'O', 'P', 'Q', 'R'};

        for(int i=0; i<zero.length; i++){
            if(zero[i] == a) return "zero";
        }

        for(int i=0; i<one.length; i++){
            if(one[i] == a) return "one";
        }

        if(a == 'B') return "two";

        return "false";
    }
}

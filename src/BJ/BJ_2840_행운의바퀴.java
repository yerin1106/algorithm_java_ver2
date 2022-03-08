package BJ;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2840_행운의바퀴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] wheel = new String[n];
        int p = 0;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            String alp = st.nextToken();

            p = (p+s) % n;
            if(wheel[p] != null && !wheel[p].equals(alp)) {
                System.out.println("!");
                System.exit(0);
            }
            wheel[p] = alp;
        }

        int[] check = new int[27];
        for (int i = 0; i < n; i++) {
            if(wheel[i] != null)   {
                check[wheel[i].charAt(0) -'A']++;
            }
        }

        for (int i = 0; i < 27; i++) {
            if(check[i]>1) {
                System.out.println("!");
                return;
            }
        }

        int i=0;
        while(i!=n){
            if(p-i < 0) break;
            if(wheel[(p-i)%n] == null) System.out.print("?");
            else System.out.print(wheel[(p-i)%n]);
            i++;
        }

        int j=1;
        while(n-j != i-1){
            if(wheel[n-j] == null) System.out.print("?");
            else System.out.print(wheel[n-j]);
            j++;
        }
    }

}

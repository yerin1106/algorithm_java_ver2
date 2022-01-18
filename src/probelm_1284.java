import java.util.Scanner;

public class probelm_1284 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int p, q, r, s, w;
        int a = 0, b = 0;
        for(int i=0; i<t; i++){
            p = sc.nextInt();
            q = sc.nextInt();
            r = sc.nextInt();
            s = sc.nextInt();
            w = sc.nextInt();

            a = w * p;

            if(w <= r) b = q;
            else b = q + (w-r)*s;

            if(a<b) System.out.println("#" + (i+1) +" " +a);
            else System.out.println("#" + (i+1) +" " +b);
        }

    }
}

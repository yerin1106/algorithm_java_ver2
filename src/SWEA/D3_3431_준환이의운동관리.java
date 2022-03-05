package SWEA;

import java.util.Scanner;

// 10조_심재서_김예린
public class D3_3431_준환이의운동관리 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int l = sc.nextInt();
            int u = sc.nextInt();
            int x = sc.nextInt();

            if(x < l) System.out.printf("#%d %d\n", i+1, l-x);
            else if(x>u) System.out.printf("#%d -1\n", i+1);
            else System.out.printf("#%d 0\n", i+1);
        }
    }
}

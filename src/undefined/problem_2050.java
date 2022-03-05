package undefined;

import java.util.Scanner;

public class problem_2050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String sen = sc.nextLine();
        char[] alp = sen.toCharArray();

        for(int i=0; i<alp.length; i++){
            System.out.print((int)alp[i] - 64 + " ");
        }
    }
}

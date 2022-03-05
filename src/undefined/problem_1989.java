package undefined;

import java.util.Scanner;

public class problem_1989 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cnt = 0;

        for(int tc = 0; tc<t; tc++){
            cnt = 0;
            String word = sc.next();
            sc.nextLine();
            String[] alp = word.split("");

            for(int i=0; i<alp.length/2; i++){
                //System.out.println(alp[i] + " " + alp[alp.length-i-1]);
                if(!alp[i].equals(alp[alp.length-i-1])){
                    System.out.printf("#%d 0\n",tc+1);
                    break;
                }
                cnt++;
            }
            if(cnt == alp.length/2)
                System.out.printf("#%d 1\n",tc+1);
        }

    }
}

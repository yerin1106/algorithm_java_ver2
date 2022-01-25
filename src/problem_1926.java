import java.util.Arrays;
import java.util.Scanner;

public class problem_1926 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 0;
        int cnt = 0;
        String s = "";
        for(int i=1; i<n+1; i++){
            num = i;
            cnt = 0;

            s = Integer.toString(i);
            String[] arr = s.split("");
            for(int j=0; j<arr.length; j++){
                if(arr[j].equals("3") || arr[j].equals("6") || arr[j].equals("9")) cnt++;
            }

            if(cnt == 0) System.out.print(i);
            else{
                for(int j=0; j<cnt; j++) System.out.print("-");
            }
            System.out.print(" ");
        }
    }
}

import java.util.Scanner;

public class problem_1945 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] num = {2, 3, 5, 7, 11};
        int[] result = new int[num.length];
        int input = 0;

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            input = sc.nextInt();
            result = new int[]{0, 0, 0, 0, 0};
            for(int j=0; j<num.length; j++){
                while(input%num[j] == 0){
                    input = input / num[j];
                    result[j]++;
                }
            }
            System.out.print("#" + (i+1));
            for(int k=0; k<result.length; k++){
                System.out.print(" " + result[k]);
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class problem_1940 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++){
            int tc = sc.nextInt();
            int cons = 0;
            int result = 0;
            for(int j=0; j<tc; j++){
                int state = sc.nextInt();
                if(state == 1 || state == 2){
                    int vel = sc.nextInt();
                    if(state == 1){
                        cons += vel;
                        result += cons;
                    }
                    else if(state == 2){
                        cons -= vel;
                        if(cons < 0) cons = 0;
                        else{
                            result += cons;
                        }
                    }
                }
                else{
                    result += cons;
                }
            }
            System.out.printf("#%d %d\n", i+1, result);
        }
    }
}
